package com.billyyccc.experiments.guava.demo;

import io.vertx.core.Vertx;

/**
 * @author Billy Yuan <billy112487983@gmail.com>
 */

public class Launcher {
  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();

    // Deploy the TestVerticle
    vertx.deployVerticle(new TestVerticle());
  }
}
