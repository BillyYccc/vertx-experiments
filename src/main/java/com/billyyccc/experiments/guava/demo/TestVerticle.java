package com.billyyccc.experiments.guava.demo;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

/**
 * @author Billy Yuan <billy112487983@gmail.com>
 */

public class TestVerticle extends AbstractVerticle {
  @Override
  public void start() throws Exception {
    // First check the current thread and current context.
    System.out.println("##TestVerticle in the thread " + Thread.currentThread().getName());
    System.out.println("##TestVerticle in the context " + Vertx.currentContext());

    FooClient fooClient = new FooClient(vertx);
    fooClient.doSomethingAsync(res -> {
      if (res.succeeded()) {
        System.out.println("Async call with FooClient is successful");
        System.out.println("The expected result is " + res.result());
      } else {
        System.out.println("Async call failed");
        System.out.println(res.cause().getMessage());
      }
    });
  }
}
