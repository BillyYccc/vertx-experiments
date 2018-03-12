package com.billyyccc.experiments.guava.demo;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/**
 * @author Billy Yuan <billy112487983@gmail.com>
 * <p>
 * An asynchronous dummy client.
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
