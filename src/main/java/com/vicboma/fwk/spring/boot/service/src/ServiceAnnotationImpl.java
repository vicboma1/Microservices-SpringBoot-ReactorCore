package com.vicboma.fwk.spring.boot.service.src;

import com.vicboma.fwk.spring.boot.model.AnnotationModel;
import com.vicboma.fwk.spring.boot.model.post.AnnotationPostModel;
import com.vicboma.fwk.spring.boot.service.api.ServiceAnnotation;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.UUID;

@Service
public class ServiceAnnotationImpl implements ServiceAnnotation {

    @Override
    public Mono<UUID> post(Mono<AnnotationModel> content) {
        return content
                .publishOn(Schedulers.parallel())
                .map(it -> AnnotationPostModel.create(
                        UUID.randomUUID(),
                        it.getTitle(), it.getAuthor(), it.getBody())
                )
                .doOnNext(it -> this.getLogger().info("doOnNext: " + it.toString()))
                .doOnError(it -> this.getLogger().error("doOnError: " + it.getMessage(), it))
                .doOnCancel(() -> this.getLogger().info("doOnCancel"))
                .doOnSuccess(it -> this.getLogger().info("doOnSuccess : " + it.toString()))
                .map(model -> model.getId());
    }

}
