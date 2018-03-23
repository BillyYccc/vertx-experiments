package com.billyyccc.experiments;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

/**
 * @author Billy Yuan <billy112487983@gmail.com>
 */

public class PolyglotClientImpl implements PolyglotClient {
  private Vertx vertx;
  private JsonObject config;

  public PolyglotClientImpl(Vertx vertx, JsonObject config) {
    this.vertx = vertx;
    this.config = config;
  }

  @Override
  public PolyglotClient writeData(Handler<AsyncResult<Void>> resultHandler) {
    System.out.println("Write some data...");
    resultHandler.handle(Future.succeededFuture());
    return this;
  }

  @Override
  public PolyglotClient readData(Handler<AsyncResult<String>> resultHandler) {
    System.out.println("Read some data...");
    resultHandler.handle(Future.succeededFuture("Your data is OK," + " data: foo"));
    return this;
  }
}
