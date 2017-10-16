package com.vicboma.fwk.spring.boot.service.api;

import com.vicboma.fwk.spring.boot.model.AnnotationModel;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ServiceAnnotation extends Service {

     Mono<UUID> post(Mono<AnnotationModel> content);
}
