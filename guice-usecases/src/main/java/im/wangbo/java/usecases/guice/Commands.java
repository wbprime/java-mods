package im.wangbo.java.usecases.guice;

public final class Commands {
  private Commands() {
    throw new UnsupportedOperationException("Construction forbidden");
  }

  public static String HELLO = "hello";
  public static String LOGIN = "login";
}
