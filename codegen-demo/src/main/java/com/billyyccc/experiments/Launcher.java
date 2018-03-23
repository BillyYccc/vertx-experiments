package com.billyyccc.experiments;

import io.vertx.core.Vertx;

/**
 * @author Billy Yuan <billy112487983@gmail.com>
 */

public class Launcher {
  public static void main(String[] args) {
    /*
     ----- Polyglot APIs -----
     1. Java Vert.x Callback(Handler<AsyncResult<T>>)
     2. Rxi-fied(RxJava)
     3. Groovy
     4. Kotlin
     5. JavaScript
     ----- Polyglot APIs -----
     */
    runCallbackExample();
    runRxJavaExample();
    runGroovyExample();
    runKotlinExample();
    runJavaScriptExample();
  }

  /**
   * Run example by calling the methods of the PolyglotClient with callback({@code Handler<AsyncResult<T>>}) API.
   */
  private static void runCallbackExample() {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle("com.billyyccc.experiments.callback.OriginalVerticle");
  }

  /**
   * Run example by calling the methods of the PolyglotClient with Rxi-fied API.
   */
  private static void runRxJavaExample() {
    io.vertx.reactivex.core.Vertx vertx = io.vertx.reactivex.core.Vertx.vertx();
    vertx.rxDeployVerticle("com.billyyccc.experiments.rxified.RxifiedVerticle")
      .subscribe();
  }

  /**
   * Run example by calling the methods of the PolyglotClient with Groovy API.
   */
  private static void runGroovyExample() {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle("groovy:com.billyyccc.experiments.groovy.groovy_verticle");
  }

  /**
   * Run example by calling the methods of the PolyglotClient with Kotlin API.
   */
  private static void runKotlinExample() {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle("kotlin:com.billyyccc.experiments.kotlin.KotlinVerticle");
  }

  /**
   * Run example by calling the methods of the PolyglotClient with JavaScript API.
   */
  private static void runJavaScriptExample() {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle("js:js_verticle.js");
  }
}
