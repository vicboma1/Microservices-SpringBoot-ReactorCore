package com.vicboma.fwk.spring.boot.controller.api;

import com.vicboma.fwk.logger.Loggable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public interface Controller extends Loggable {

    @PostConstruct
    default void initIt() throws Exception {
       this.getLogger().info("Controller - @PostConstruct: "+this.getClass());
    }

    @PreDestroy
    default void cleanUp() throws Exception {
        this.getLogger().info("Controller - @PreDestroy: "+this.getClass());
    }

}
