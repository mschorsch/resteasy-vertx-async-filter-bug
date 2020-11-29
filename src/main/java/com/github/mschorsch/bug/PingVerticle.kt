package com.github.mschorsch.bug

import io.vertx.core.AbstractVerticle
import io.vertx.core.eventbus.Message

class PingVerticle : AbstractVerticle() {

    override fun start() {
        vertx.eventBus().consumer("ping") { msg: Message<Any?> ->
            msg.reply("pong")
        }
    }
}
