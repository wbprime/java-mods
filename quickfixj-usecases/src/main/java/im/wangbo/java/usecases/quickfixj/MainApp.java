package im.wangbo.java.usecases.quickfixj;

import quickfix.*;
import quickfix.field.TestReqID;
import quickfix.fix44.TestRequest;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.logging.Logger;

public class MainApp {
    private static final Logger L = Logger.getLogger(MainApp.class.getName());

    public static final String SERVER_COMP_ID = "server_comp_id";
    public static final String CLIENT_COMP_ID = "client_comp_id";

    public static final int PORT = ThreadLocalRandom.current().nextInt(10000, 20000);

    public static void main(String[] args) throws Exception {
        Acceptor server = null;
        Initiator client = null;

        try {
            server = startServer();

            client = startClient();

            startLogic(server, client);
        } finally {
            if (null != client) client.stop();

            if (null != server) server.stop();
        }
    }

    private static void startLogic(final Acceptor server, final Initiator client) throws Exception {
        final TestRequest message = new TestRequest();
        for (int i = 0; i < 100; i++) {
            message.set(new TestReqID(String.format("The %d-th request", i)));
            client.getSessions().forEach(
                s -> {
                    final Session session = Session.lookupSession(s);
                    if (null != session) {
                        session.send(message);
                    }
                }
            );

            TimeUnit.SECONDS.sleep(1L);
        }
    }

    private static Acceptor startServer() throws Exception {
        final SessionSettings settings = createSettings(
            SessionId.fix44Builder()
                .senderCompID(SERVER_COMP_ID)
                .targetCompID(CLIENT_COMP_ID)
                .build(),
            (s, id) -> {
                s.setString(id, SessionFactory.SETTING_CONNECTION_TYPE, SessionFactory.ACCEPTOR_CONNECTION_TYPE);
                s.setLong(id, "SocketAcceptPort", PORT);
            });
        final ThreadedSocketAcceptor acceptor = ThreadedSocketAcceptor.newBuilder()
            .withSettings(settings)
            .withApplication(new ClientApplication())
            .withLogFactory(new SLF4JLogFactory(settings))
            .withMessageFactory(new DefaultMessageFactory())
            .withMessageStoreFactory(new MemoryStoreFactory())
            .build();

        acceptor.start();

        return acceptor;
    }

    private static Initiator startClient() throws Exception {
        final SessionSettings settings = createSettings(
            SessionId.fix44Builder()
                .senderCompID(CLIENT_COMP_ID)
                .targetCompID(SERVER_COMP_ID)
                .build(),
            (s, id) -> {
                s.setString(id, SessionFactory.SETTING_CONNECTION_TYPE, SessionFactory.INITIATOR_CONNECTION_TYPE);
                s.setString(id, "SocketConnectHost", "127.0.0.1");
                s.setLong(id, "SocketConnectPort", PORT);
            });

        final SocketInitiator initiator = SocketInitiator.newBuilder()
            .withSettings(settings)
            .withApplication(new ServerApplication())
            .withLogFactory(new SLF4JLogFactory(settings))
            .withMessageFactory(new DefaultMessageFactory())
            .withMessageStoreFactory(new MemoryStoreFactory())
            .build();

        initiator.start();

        return initiator;
    }

    private static SessionSettings createSettings(
        final SessionId sessionId,
        final BiConsumer<SessionSettings, SessionID> customizer
    ) {
        final SessionSettings settings = new SessionSettings();

        settings.setString("SocketAcceptAddress", "127.0.0.1");

        final SessionID id = new SessionID(
            sessionId.beginString(),
            sessionId.senderCompID(),
            sessionId.senderSubID().orElse(""),
            sessionId.senderLocationID().orElse(""),
            sessionId.targetCompID(),
            sessionId.targetSubID().orElse(""),
            sessionId.targetLocationID().orElse(""),
            sessionId.sessionQualifier().orElse("")
        );

        settings.setString(id, SessionSettings.BEGINSTRING, sessionId.beginString());
        settings.setString(id, SessionSettings.SENDERCOMPID, sessionId.senderCompID());
        settings.setString(id, SessionSettings.TARGETCOMPID, sessionId.targetCompID());
        sessionId.senderSubID().ifPresent(s -> settings.setString(id, SessionSettings.SENDERSUBID, s));
        sessionId.senderLocationID().ifPresent(s -> settings.setString(id, SessionSettings.SENDERLOCID, s));
        sessionId.targetSubID().ifPresent(s -> settings.setString(id, SessionSettings.TARGETSUBID, s));
        sessionId.targetLocationID().ifPresent(s -> settings.setString(id, SessionSettings.TARGETLOCID, s));
        sessionId.sessionQualifier().ifPresent(s -> settings.setString(id, SessionSettings.SESSION_QUALIFIER, s));

        settings.setLong(id, "HeartBtInt", 2);
        settings.setString(id, "TimeZone", "Asia/Shanghai");
        settings.setString(id, "StartTime", LocalTime.of(5, 0, 0).format(DateTimeFormatter.ISO_LOCAL_TIME));
        settings.setString(id, "EndTime", LocalTime.of(22, 0, 0).format(DateTimeFormatter.ISO_LOCAL_TIME));
        settings.setBool(id, "AllowUnknownMsgFields", true);
        settings.setBool(id, "RejectInvalidMessage", false);

        customizer.accept(settings, id);

        return settings;
    }


}
