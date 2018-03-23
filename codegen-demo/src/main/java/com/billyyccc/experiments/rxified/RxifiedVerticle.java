package com.billyyccc.experiments.rxified;

import com.billyyccc.reactivex.experiments.PolyglotClient;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.AbstractVerticle;

/**
 * @author Billy Yuan <billy112487983@gmail.com>
 */

public class RxifiedVerticle extends AbstractVerticle {
  @Override
  public void start() throws Exception {
    PolyglotClient rxifiedClient = PolyglotClient.create(vertx, new JsonObject());
    Completable completable = rxifiedClient.rxWriteData();
    completable.subscribe(
      () -> {
        System.out.println("Write Success...");
      }, throwable -> {
        System.out.println("Write Failed...");
      });
    Single<String> single = rxifiedClient.rxReadData();
    single.subscribe(
      result -> {
        System.out.println("Read Success...");
        System.out.println(result);
      }, throwable -> {
        System.out.println("Read failed...");
      });
  }
}
