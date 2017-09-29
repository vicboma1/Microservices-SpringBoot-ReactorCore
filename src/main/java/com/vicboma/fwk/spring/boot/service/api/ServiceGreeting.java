package com.vicboma.fwk.spring.boot.service.api;

import com.vicboma.fwk.spring.boot.model.GrettingModel;
import reactor.core.publisher.Mono;

public interface ServiceGreeting extends Service {
    Mono<GrettingModel> get(String name);
}
