package com.vicboma.fwk.spring.boot.service.api;

import com.vicboma.fwk.spring.boot.model.HelloWorldModel;
import reactor.core.publisher.Mono;

public interface ServiceHelloWorld extends Service {
    Mono<HelloWorldModel> get();
}
