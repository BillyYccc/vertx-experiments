package com.billyyccc.experiments.callback;

import com.billyyccc.experiments.PolyglotClient;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;

/**
 * @author Billy Yuan <billy112487983@gmail.com>
 */

public class OriginalVerticle extends AbstractVerticle {
  @Override
  public void start() throws Exception {
    PolyglotClient originalClient = PolyglotClient.create(vertx, new JsonObject());
    originalClient.writeData(res -> {
      if (res.succeeded()) {
        System.out.println("Write Success...");
      } else {
        System.out.println("Write Failed...");
      }
    });
    originalClient.readData(res -> {
      if (res.succeeded()) {
        System.out.println("Read Success...");
        System.out.println(res.result());
      } else {
        System.out.println("Read failed...");
      }
    });
  }
}
