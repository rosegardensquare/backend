package com.zs.backend.config;

import com.alibaba.ttl.threadpool.TtlExecutors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class BackendServiceConfig {


    @Bean
    public ExecutorService batchModifyBillingThreadPool() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setMaxPoolSize(10);
        threadPoolTaskExecutor.setQueueCapacity(1500);
        threadPoolTaskExecutor.setThreadNamePrefix("BatchModify-");
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskExecutor.setKeepAliveSeconds(0);
        threadPoolTaskExecutor.initialize();
        return TtlExecutors.getTtlExecutorService(threadPoolTaskExecutor.getThreadPoolExecutor());
    }
}
