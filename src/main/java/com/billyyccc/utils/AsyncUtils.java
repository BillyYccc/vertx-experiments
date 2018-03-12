package com.billyyccc.utils;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import io.vertx.core.Future;

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
}