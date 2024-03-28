package com.hanxi.generaladministration;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.request.RequestContextListener;



@Slf4j
@SpringBootApplication(scanBasePackages = {"com.hanxi.generaladministration"})
@EnableAsync
@ServletComponentScan
@EnableMethodCache(basePackages = "com.hanxi.generaladministration") // 指定需要缓存的方法所在的包
@EnableCreateCacheAnnotation // 启用@CreateCache注解
public class HanxiGeneralAdministrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(HanxiGeneralAdministrationApplication.class,args);
    }

    @Bean
    @ConditionalOnMissingBean(RequestContextListener.class)
    public RequestContextListener requestContextListener(){
        return new RequestContextListener();
    }

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        return executor;
    }




}
