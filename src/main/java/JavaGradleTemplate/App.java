package JavaGradleTemplate;

import javax.annotation.Nonnull;

public class App {
  public @Nonnull String getGreeting() {
    return "Greetings!";
  }

  public static void main(String[] args) {
    System.out.println(new App().getGreeting());
  }
}
