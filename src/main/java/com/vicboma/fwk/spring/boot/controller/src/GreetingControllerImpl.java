package com.vicboma.fwk.spring.boot.controller.src;

import com.vicboma.fwk.spring.boot.controller.api.GreetingController;
import com.vicboma.fwk.spring.boot.model.GrettingModel;
import com.vicboma.fwk.spring.boot.service.api.Service;
import com.vicboma.fwk.spring.boot.service.api.ServiceGreeting;
import com.vicboma.fwk.spring.boot.service.api.ServiceHelloWorld;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
public class GreetingControllerImpl implements GreetingController {

    private ServiceGreeting serviceGreeting;

    public GreetingControllerImpl(ServiceGreeting serviceGreeting)  {
        this.serviceGreeting = serviceGreeting;
        this.getLogger().info("Initialize GreetingController "+serviceGreeting);
    }

    @Override
    @GetMapping("/hi/{name}")
    public Mono<GrettingModel> hi(@PathVariable String name) {
        this.getLogger().info("GetMapping -> '/hi/{"+name+"}");
        return this.serviceGreeting.get(name);
    }

}