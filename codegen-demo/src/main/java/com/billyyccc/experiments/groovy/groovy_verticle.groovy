package com.billyyccc.experiments.groovy

import com.billyyccc.experiments.PolyglotClient
import io.vertx.core.AbstractVerticle
import io.vertx.core.json.JsonObject

/**
 * @author Billy Yuan <billy112487983@gmail.com>
 */

class groovy_verticle extends AbstractVerticle {
  @Override
  void start() throws Exception {
    PolyglotClient originalClient = PolyglotClient.create(vertx, new JsonObject())
    originalClient.writeData({ res ->
      if (res.succeeded()) {
        println "Write Success..."
      } else {
        println "Write Failed..."
      }
    })

    originalClient.readData({ res ->
      if (res.succeeded()) {
        println "Read Success..."
        println res.result()
      } else {
        println "Read failed..."
      }
    })
  }
}
