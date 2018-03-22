package com.billyyccc.experiments;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/**
 * An asynchronous dummy client which executes async methods and returns {@code ListenableFuture}.
 *
 * @author Billy Yuan <billy112487983@gmail.com>
 */

public class DummyClient {
  /**
   * a mock async API of the client.
   *
   * @return an ListenableFuture with a result.
   */
  ListenableFuture<String> asyncCallWithResults() {
    return Futures.immediateFuture("The value is ok. " + "Running Thread in " + Thread.currentThread().getName());
  }

  /**
   * a mock async API of the client.
   *
   * @return an ListenableFuture with a failure.
   */
  ListenableFuture<String> asyncCallWithFailure() {
    return Futures.immediateFailedFuture(new Throwable("Failed message..."));
  }
}
