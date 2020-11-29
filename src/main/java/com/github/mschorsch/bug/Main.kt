package com.github.mschorsch.bug

import io.vertx.core.Vertx

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        System.setProperty("vertx.logger-delegate-factory-class-name", "io.vertx.core.logging.Log4j2LogDelegateFactory")
        val vertx = Vertx.vertx()
        vertx.deployVerticle(PingVerticle())
        vertx.deployVerticle(WebserverVerticle())
    }
}
