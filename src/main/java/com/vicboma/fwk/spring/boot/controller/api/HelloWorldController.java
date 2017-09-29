package com.vicboma.fwk.spring.boot.controller.api;

import com.vicboma.fwk.spring.boot.model.HelloWorldModel;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

public interface HelloWorldController extends Controller {

    @GetMapping("/")
    Mono<HelloWorldModel> home();
}
