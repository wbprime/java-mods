package im.wangbo.java.usecases.quickfixj;

import com.google.common.flogger.FluentLogger;
import quickfix.*;

class ServerApplication implements Application {

    private static final FluentLogger log = FluentLogger.forEnclosingClass();

    @Override
    public void onCreate(SessionID sessionId) {
        log.atWarning().log("Session created %s", sessionId);
    }

    @Override
    public void onLogon(SessionID sessionId) {
        log.atWarning().log("Session logon %s", sessionId);
    }

    @Override
    public void onLogout(SessionID sessionId) {
        log.atWarning().log("Session logout %s", sessionId);
    }

    @Override
    public void toAdmin(Message message, SessionID sessionId) {
        log.atWarning().log("Admin message transmitted to %s: %s", sessionId, message);
    }

    @Override
    public void fromAdmin(Message message, SessionID sessionId) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        log.atWarning().log("Admin message received from %s: %s", sessionId, message);
    }

    @Override
    public void toApp(Message message, SessionID sessionId) throws DoNotSend {
        log.atWarning().log("App message transmitted to %s: %s", sessionId, message);
    }

    @Override
    public void fromApp(Message message, SessionID sessionId) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        log.atWarning().log("App message received from %s: %s", sessionId, message);
    }
}
