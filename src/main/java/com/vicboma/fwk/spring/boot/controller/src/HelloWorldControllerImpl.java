package com.vicboma.fwk.spring.boot.controller.src;


import com.vicboma.fwk.spring.boot.controller.api.HelloWorldController;
import com.vicboma.fwk.spring.boot.model.HelloWorldModel;
import com.vicboma.fwk.spring.boot.service.api.ServiceGreeting;
import com.vicboma.fwk.spring.boot.service.api.ServiceHelloWorld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloWorldControllerImpl implements HelloWorldController {

    private ServiceHelloWorld serviceHelloWorld;

    public HelloWorldControllerImpl(ServiceHelloWorld serviceHelloWorld)  {
        this.serviceHelloWorld = serviceHelloWorld;
        this.getLogger().info("Initialize HelloWorldController "+this.serviceHelloWorld);
    }

    @Override
    @GetMapping("/")
    public Mono<HelloWorldModel> home() {
        this.getLogger().info("RequestMapping -> /");
        return this.serviceHelloWorld.get();
    }
}
