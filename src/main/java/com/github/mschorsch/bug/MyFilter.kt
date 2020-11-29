package com.github.mschorsch.bug

import io.vertx.core.Future
import io.vertx.core.Promise
import io.vertx.core.Vertx
import io.vertx.core.eventbus.Message
import org.apache.logging.log4j.LogManager
import org.jboss.resteasy.core.ResteasyContext
import org.jboss.resteasy.core.interception.jaxrs.SuspendableContainerRequestContext
import javax.ws.rs.container.ContainerRequestContext
import javax.ws.rs.container.ContainerRequestFilter
import javax.ws.rs.ext.Provider

@Provider
class MyFilter : ContainerRequestFilter {

    override fun filter(requestContext: ContainerRequestContext) {
        val suspendable = requestContext as SuspendableContainerRequestContext
        suspendable.suspend()

        val vertx = ResteasyContext.getContextData(Vertx::class.java)

        vertx.requestPing().onComplete {
            if (it.succeeded()) {
                suspendable.resume()
            } else {
                suspendable.resume(it.cause())
            }
        }
    }

    private fun Vertx.requestPing(): Future<Message<String>> {
        val promise = Promise.promise<Message<String>>()
        eventBus().request("ping", null, promise)
        return promise.future()
    }

    companion object {
        private val logger = LogManager.getLogger(MyFilter::class.java)
    }
}