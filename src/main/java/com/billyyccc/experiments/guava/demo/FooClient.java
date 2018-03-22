package com.billyyccc.experiments.guava.demo;

import com.google.common.util.concurrent.ListenableFuture;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

import static com.billyyccc.utils.AsyncUtils.*;

/**
 * A client running in the context of Vert.x, this client is a wrapper of the DummyClient.
 *
 * @author Billy Yuan <billy112487983@gmail.com>
 */

public class FooClient {
  private Vertx vertx;

  public FooClient(Vertx vertx) {
    this.vertx = vertx;
  }

  /**
   * This is an async call with a Vert.x callback, wrapping the method of DummyClient.
   *
   * @param handler the result handler.
   */
  public void doSomethingAsync(Handler<AsyncResult<String>> handler) {
    DummyClient dummyClient = new DummyClient();
    ListenableFuture<String> listenableFuture = dummyClient.asyncCallWithResults();

    runOnContext(vertx, listenableFuture, handler);

    System.out.println("Current Thread is " + Thread.currentThread().getName());
  }
}
