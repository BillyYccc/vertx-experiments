package com.billyyccc.experiments;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

/**
 * @author Billy Yuan <billy112487983@gmail.com>
 */

public class Launcher {
  public static void main(String[] args) {
    VertxOptions vertxOptions = new VertxOptions()
      .setEventLoopPoolSize(1);
    Vertx vertx = Vertx.vertx(vertxOptions);

    // Deploy the TestVerticle
    vertx.deployVerticle("com.billyyccc.experiments.TestVerticle",
      new DeploymentOptions().setInstances(2));
  }
}
