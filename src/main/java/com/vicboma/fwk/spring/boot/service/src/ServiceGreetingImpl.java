package com.vicboma.fwk.spring.boot.service.src;

import com.vicboma.fwk.spring.boot.model.GrettingModel;
import com.vicboma.fwk.spring.boot.model.HelloWorldModel;
import com.vicboma.fwk.spring.boot.service.api.ServiceGreeting;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class ServiceGreetingImpl implements ServiceGreeting {

    public ServiceGreetingImpl() {
       this.getLogger().info("Initialize ServiceImpl");
   }

    @Override
    public Mono<GrettingModel> get(String name) {
       return Mono.defer(
                () -> Mono.justOrEmpty(name)
        )
        .subscribeOn(Schedulers.elastic())
        .doOnSubscribe(it -> this.getLogger().info("doOnSubscribe: " + it))
        .doOnError(it -> this.getLogger().error("doOnError: " + it.getMessage(), it))
        .doOnCancel(() -> this.getLogger().info("doOnCancel"))
        .doOnSuccess(it -> this.getLogger().info("doOnSuccess : "+it))
        .map(model ->  GrettingModel.create(model));
   }
}
