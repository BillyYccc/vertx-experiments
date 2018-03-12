package com.billyyccc.experiments.guava.demo;

import com.billyyccc.utils.AsyncUtils;
import com.google.common.util.concurrent.ListenableFuture;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

/**
 * @author Billy Yuan <billy112487983@gmail.com>
 * <p>
 * a client running in the context of Vert.x, this client is a wrapper of the DummyClient.
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

    vertx.runOnContext(v -> {
      // non-blocking handler
      handler.handle(AsyncUtils.convertToVertxFutureGracefully(listenableFuture));
//      AsyncUtils.convertToVertxFutureGracefully(listenableFuture).setHandler(handler);
      System.out.println("The running Context is " + Vertx.currentContext());
    });

    System.out.println("Current Thread is " + Thread.currentThread().getName());
  }
}
