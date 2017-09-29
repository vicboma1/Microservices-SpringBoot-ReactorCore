package com.vicboma.fwk.spring.boot.controller.api;

import com.vicboma.fwk.spring.boot.model.GrettingModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

public interface GreetingController extends Controller {

    @GetMapping("/hi/{name}")
    Mono<GrettingModel> hi(@PathVariable String name);
}
