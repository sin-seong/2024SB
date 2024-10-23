package com.sin.sb1010_2.config;

import com.sin.sb1010_2.aspect.CacheAsapect;
import com.sin.sb1010_2.aspect.ExeTimeAspect;
import com.sin.sb1010_2.chap07.Calculator;
import com.sin.sb1010_2.chap07.RecCalculator;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppCtxWithCache {

    @Bean
    public CacheAsapect cacheAsapect() {
        return new CacheAsapect();
    }

    @Bean
    public ExeTimeAspect exeTimeAspect() {
        return new ExeTimeAspect();
    }
    @Bean
    public Calculator calculator() {
        return new RecCalculator();
    }
}
