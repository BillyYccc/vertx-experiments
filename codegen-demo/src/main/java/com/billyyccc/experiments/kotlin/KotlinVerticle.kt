package com.billyyccc.experiments.kotlin

import com.billyyccc.experiments.PolyglotClient
import io.vertx.core.AbstractVerticle
import io.vertx.kotlin.core.json.JsonObject

class KotlinVerticle : AbstractVerticle() {
    override fun start() {
        val kotlinClient = PolyglotClient.create(vertx, JsonObject())
        kotlinClient.writeData({ ar ->
            run {
                if (ar.succeeded()) {
                    println("Write Success...")
                } else {
                    println("Write Failed...")
                }
            }
        })

        kotlinClient.readData({ ar ->
            run {
                if (ar.succeeded()) {
                    println("Read Success...")
                    println(ar.result())
                } else {
                    println("Read Failed...")
                }
            }
        })
    }
}
