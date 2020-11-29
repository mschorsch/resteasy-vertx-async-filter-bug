package com.github.mschorsch.bug

import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.container.AsyncResponse
import javax.ws.rs.container.Suspended

@Path("/")
class MyResource {

    @GET
    @Path("/ping1")
    fun ping1(
        @Suspended asyncResponse: AsyncResponse
    ) {
        asyncResponse.resume("OK")
    }

    @GET
    @Path("/ping2")
    fun ping2(): CompletionStage<String> {
        return CompletableFuture.completedFuture("OK")
    }
}
