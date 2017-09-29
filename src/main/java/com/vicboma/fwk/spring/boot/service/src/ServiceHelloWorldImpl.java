package com.vicboma.fwk.spring.boot.service.src;

import com.vicboma.fwk.spring.boot.model.GrettingModel;
import com.vicboma.fwk.spring.boot.model.HelloWorldModel;
import com.vicboma.fwk.spring.boot.service.api.ServiceHelloWorld;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class ServiceHelloWorldImpl implements ServiceHelloWorld {

    public ServiceHelloWorldImpl() {
       this.getLogger().info("Initialize ServiceHelloWorldImpl");
   }

    @Override
    public Mono<HelloWorldModel> get() {
        return Mono.defer(
                () -> Mono.justOrEmpty(
                        HelloWorldModel.create(HelloWorldModel.HELLO_WORLD)
                )
        )
        .subscribeOn(Schedulers.elastic())
        .doOnSubscribe(it -> this.getLogger().info("doOnSubscribe: " + it))
        .doOnError(it ->     this.getLogger().error("doOnError: " + it.getMessage(), it))
        .doOnCancel(() ->    this.getLogger().info("doOnCancel"))
        .doOnSuccess(it ->   this.getLogger().info("doOnSuccess : "+it))
        .subscribeOn(Schedulers.elastic());
    }
}
