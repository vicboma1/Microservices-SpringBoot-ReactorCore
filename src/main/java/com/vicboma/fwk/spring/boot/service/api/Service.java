package com.vicboma.fwk.spring.boot.service.api;

import com.vicboma.fwk.logger.Loggable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public interface Service<T> extends Loggable{

    @PostConstruct
    default void initIt() throws Exception {
        this.getLogger().info("Service - @PostConstruct: "+this.getClass());
    }

    @PreDestroy
    default void cleanUp() throws Exception {
        this.getLogger().info("Service - @PreDestroy: "+this.getClass());
    }
}
