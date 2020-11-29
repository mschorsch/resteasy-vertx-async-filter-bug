package com.github.mschorsch.bug

import io.vertx.core.AbstractVerticle
import org.jboss.resteasy.plugins.server.vertx.VertxRequestHandler
import org.jboss.resteasy.plugins.server.vertx.VertxResteasyDeployment
import javax.ws.rs.core.Application

private object MyApplication : Application() {

    override fun getClasses(): Set<Class<*>> = setOf(
        MyFilter::class.java
    )
}

class WebserverVerticle : AbstractVerticle() {

    override fun start() {
        val deployment = VertxResteasyDeployment()
        deployment.application = MyApplication
        deployment.start()
        deployment.registry.addPerInstanceResource(MyResource::class.java)

        vertx.createHttpServer()
            .requestHandler(VertxRequestHandler(vertx, deployment))
            .listen(8888)

        println(
            """
            ###########################################################################
            Bug: http://localhost:8888/ping1
            OK: http://localhost:8888/ping2
            ###########################################################################
        """.trimIndent()
        )
    }
}