package io.github.rami3l.template.java;

import lombok.Getter;

public class App {
  @Getter private String greeting = "Greetings!";

  public static void main(String[] args) {
    System.out.println(new App().getGreeting());
  }
}
