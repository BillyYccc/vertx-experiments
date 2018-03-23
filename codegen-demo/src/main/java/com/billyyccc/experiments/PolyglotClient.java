package com.billyyccc.experiments;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

/**
 * A polyglot Client which supports the various languages and RxJava/RxJava2.
 *
 * @author Billy Yuan <billy112487983@gmail.com>
 */

@VertxGen
public interface PolyglotClient {

  static PolyglotClient create(Vertx vertx, JsonObject config) {
    return new PolyglotClientImpl(vertx, config);
  }

  @Fluent
  PolyglotClient writeData(Handler<AsyncResult<Void>> resultHandler);

  @Fluent
  PolyglotClient readData(Handler<AsyncResult<String>> resultHandler);

}
