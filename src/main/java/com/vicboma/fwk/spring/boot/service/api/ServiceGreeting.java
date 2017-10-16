package com.vicboma.fwk.spring.boot.service.api;

import com.vicboma.fwk.spring.boot.model.GrettingModel;
import reactor.core.publisher.Mono;

public interface ServiceGreeting extends Service {

    long TIME_DEFAULT = 1500L;

    Mono<GrettingModel> get(String name);
    Mono<GrettingModel> getDelay(String name);
    Mono<GrettingModel> getDelayTime(String name, Long time);
}
