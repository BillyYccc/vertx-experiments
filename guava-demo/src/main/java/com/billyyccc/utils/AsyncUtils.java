package com.billyyccc.utils;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import io.vertx.core.AsyncResult;
import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

/**
 * @author Billy Yuan <billy112487983@gmail.com>
 */

public class AsyncUtils {
  /**
   * Convert a Guava ListenableFuture to a Vert.x Future, running the callback code
   * in the current Thread.
   *
   * @param listenableFuture the ListenableFuture to be converted
   * @param <T>              the wrapped result
   * @return the converted Vert.x Future
   */
  public static <T> Future<T> convertToVertxFutureGracefully(ListenableFuture<T> listenableFuture) {
    Future<T> vertxFuture = Future.future();

    Futures.addCallback(listenableFuture, new FutureCallback<T>() {
      @Override
      public void onSuccess(T result) {
        vertxFuture.complete(result);
      }

      @Override
      public void onFailure(Throwable t) {
        vertxFuture.fail(t);
      }
    }, MoreExecutors.newDirectExecutorService());
    return vertxFuture;
  }


  /**
   * Execute the handler in the current Vert.x Context as soon as the listenableFuture returns a result/failure.
   *
   * @param vertx            the current vertx instance
   * @param listenableFuture the listenableFuture returned by your target wrapping method
   * @param handler          your handler to handle the listenableFuture result
   * @param <T>              the type of the listenableFuture result
   */
  public static <T> void runOnContext(Vertx vertx, ListenableFuture<T> listenableFuture, Handler<AsyncResult<T>> handler) {
    Context context = vertx.getOrCreateContext();

    context.runOnContext(v -> {
      handler.handle(AsyncUtils.convertToVertxFutureGracefully(listenableFuture));
//      AsyncUtils.convertToVertxFutureGracefully(listenableFuture).setHandler(handler);
      System.out.println("The running Context is " + Vertx.currentContext());
    });
  }
}