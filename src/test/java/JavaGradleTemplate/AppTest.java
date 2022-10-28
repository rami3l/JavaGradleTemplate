package JavaGradleTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class AppTest {
  @Test
  void appHasAGreeting() {
    var app = new App();
    assertNotNull(app.getGreeting(), "app should have a greeting");
  }
}
