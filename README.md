# resteasy-vertx-async-filter-bug

__Suspendable-Filter + Suspendable-Method (http://localhost:8888/ping1)__
```
RESTEASY003320: Failed processing arguments of public final void com.github.mschorsch.bug.MyResource.ping1(javax.ws.rs.container.AsyncResponse)
```

```kotlin
javax.ws.rs.BadRequestException: RESTEASY003320: Failed processing arguments of public final void com.github.mschorsch.bug.MyResource.ping1(javax.ws.rs.container.AsyncResponse)
	at org.jboss.resteasy.core.MethodInjectorImpl.injectArguments(MethodInjectorImpl.java:120) ~[resteasy-core-4.5.8.Final.jar:4.5.8.Final]
	at org.jboss.resteasy.core.MethodInjectorImpl.invoke(MethodInjectorImpl.java:128) ~[resteasy-core-4.5.8.Final.jar:4.5.8.Final]
	at org.jboss.resteasy.core.ResourceMethodInvoker.internalInvokeOnTarget(ResourceMethodInvoker.java:643) ~[resteasy-core-4.5.8.Final.jar:4.5.8.Final]
	at org.jboss.resteasy.core.ResourceMethodInvoker.invokeOnTargetAfterFilter(ResourceMethodInvoker.java:507) ~[resteasy-core-4.5.8.Final.jar:4.5.8.Final]
	at org.jboss.resteasy.core.ResourceMethodInvoker.lambda$invokeOnTarget$2(ResourceMethodInvoker.java:457) ~[resteasy-core-4.5.8.Final.jar:4.5.8.Final]
	at org.jboss.resteasy.core.interception.jaxrs.PreMatchContainerRequestContext.filter(PreMatchContainerRequestContext.java:364) ~[resteasy-core-4.5.8.Final.jar:4.5.8.Final]
	at org.jboss.resteasy.core.interception.jaxrs.PreMatchContainerRequestContext.resume(PreMatchContainerRequestContext.java:262) ~[resteasy-core-4.5.8.Final.jar:4.5.8.Final]
	at com.github.mschorsch.bug.MyFilter$filter$1.handle(MyFilter.kt:25) ~[classes/:?]
	at com.github.mschorsch.bug.MyFilter$filter$1.handle(MyFilter.kt:15) ~[classes/:?]
	at io.vertx.core.impl.FutureImpl.dispatch(FutureImpl.java:105) ~[vertx-core-3.9.4.jar:3.9.4]
	at io.vertx.core.impl.FutureImpl.tryComplete(FutureImpl.java:150) ~[vertx-core-3.9.4.jar:3.9.4]
	at io.vertx.core.impl.FutureImpl.complete(FutureImpl.java:111) ~[vertx-core-3.9.4.jar:3.9.4]
	at io.vertx.core.impl.FutureImpl.handle(FutureImpl.java:176) ~[vertx-core-3.9.4.jar:3.9.4]
	at io.vertx.core.impl.FutureImpl.handle(FutureImpl.java:21) ~[vertx-core-3.9.4.jar:3.9.4]
	at io.vertx.core.eventbus.impl.EventBusImpl.lambda$convertHandler$2(EventBusImpl.java:342) ~[vertx-core-3.9.4.jar:3.9.4]
	at io.vertx.core.eventbus.impl.HandlerRegistration.deliver(HandlerRegistration.java:278) ~[vertx-core-3.9.4.jar:3.9.4]
	at io.vertx.core.eventbus.impl.HandlerRegistration.handle(HandlerRegistration.java:264) ~[vertx-core-3.9.4.jar:3.9.4]
	at io.vertx.core.eventbus.impl.EventBusImpl$InboundDeliveryContext.next(EventBusImpl.java:567) ~[vertx-core-3.9.4.jar:3.9.4]
	at io.vertx.core.eventbus.impl.EventBusImpl.lambda$deliverToHandler$4(EventBusImpl.java:527) ~[vertx-core-3.9.4.jar:3.9.4]
	at io.vertx.core.impl.ContextImpl.executeTask(ContextImpl.java:366) ~[vertx-core-3.9.4.jar:3.9.4]
	at io.vertx.core.impl.EventLoopContext.lambda$executeAsync$0(EventLoopContext.java:38) ~[vertx-core-3.9.4.jar:3.9.4]
	at io.netty.util.concurrent.AbstractEventExecutor.safeExecute$$$capture(AbstractEventExecutor.java:164) [netty-common-4.1.49.Final.jar:4.1.49.Final]
	at io.netty.util.concurrent.AbstractEventExecutor.safeExecute(AbstractEventExecutor.java) [netty-common-4.1.49.Final.jar:4.1.49.Final]
	at io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:472) [netty-common-4.1.49.Final.jar:4.1.49.Final]
	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:497) [netty-transport-4.1.49.Final.jar:4.1.49.Final]
	at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:989) [netty-common-4.1.49.Final.jar:4.1.49.Final]
	at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74) [netty-common-4.1.49.Final.jar:4.1.49.Final]
	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30) [netty-common-4.1.49.Final.jar:4.1.49.Final]
	at java.lang.Thread.run(Thread.java:748) [?:1.8.0_272]
Caused by: java.lang.IllegalStateException: RESTEASY019505: Already suspended
	at org.jboss.resteasy.plugins.server.vertx.VertxHttpRequest$VertxExecutionContext.suspend(VertxHttpRequest.java:229) ~[resteasy-vertx-4.5.8.Final.jar:4.5.8.Final]
	at org.jboss.resteasy.plugins.server.vertx.VertxHttpRequest$VertxExecutionContext.suspend(VertxHttpRequest.java:221) ~[resteasy-vertx-4.5.8.Final.jar:4.5.8.Final]
	at org.jboss.resteasy.plugins.server.vertx.VertxHttpRequest$VertxExecutionContext.suspend(VertxHttpRequest.java:215) ~[resteasy-vertx-4.5.8.Final.jar:4.5.8.Final]
	at org.jboss.resteasy.core.AsynchronousResponseInjector.inject(AsynchronousResponseInjector.java:36) ~[resteasy-core-4.5.8.Final.jar:4.5.8.Final]
	at org.jboss.resteasy.core.MethodInjectorImpl.injectArguments(MethodInjectorImpl.java:95) ~[resteasy-core-4.5.8.Final.jar:4.5.8.Final]
	... 28 more
```

__Suspendable-Filter + Async-Method (http://localhost:8888/ping2)__
```kotlin
OK
```