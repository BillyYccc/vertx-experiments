package com.billyyccc.experiments;

import com.billyyccc.experiments.impl.ExperimentApplicationImpl;
import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.Vertx;

/**
 * An Experiment application to provide message delivery.
 *
 * @author Billy Yuan <billy112487983@gmail.com>
 */
@VertxGen
public interface ExperimentApplication {
  static ExperimentApplication createApplication() {
    return new ExperimentApplicationImpl();
  }

  static void deployHttpServer(Vertx vertx) {
    vertx.createHttpServer().requestHandler(req -> {
      req.response().putHeader("content-type", "text/plain")
        .end("This is a message from an experiment HTTP server.");
    }).listen(8080, "localhost");
  }

  static void deployTcpServer(Vertx vertx) {
    vertx.createNetServer().connectHandler(socket -> {
      socket.write("This is a message from an experiment TCP server.")
        .end();
    }).listen(1234, "localhost");
  }

  @Fluent
  ExperimentApplication send(String message, String address);
}
