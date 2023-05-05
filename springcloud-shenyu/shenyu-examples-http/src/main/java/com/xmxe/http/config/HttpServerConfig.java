package com.xmxe.http.config;

import com.xmxe.http.router.ShenyuTestHttpRouter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * HttpServerConfig.
 */
@Configuration
public class HttpServerConfig {

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(final ShenyuTestHttpRouter shenyuTestHttpRouter) {
        return shenyuTestHttpRouter.routes();
    }

    @Bean
    public Scheduler scheduler() {
        ExecutorService threadPool = new ThreadPoolExecutor(100, 100,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(),
            runnable -> {
                Thread thread = new Thread(runnable, "http-exe");
                thread.setDaemon(false);
                if (thread.getPriority() != Thread.NORM_PRIORITY) {
                    thread.setPriority(Thread.NORM_PRIORITY);
                }
                return thread;
            });
        return Schedulers.fromExecutor(threadPool);
    }
}