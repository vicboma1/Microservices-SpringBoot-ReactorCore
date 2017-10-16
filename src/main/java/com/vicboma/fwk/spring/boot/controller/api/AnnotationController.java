package com.vicboma.fwk.spring.boot.controller.api;

import com.vicboma.fwk.spring.boot.model.AnnotationModel;
import com.vicboma.fwk.spring.boot.model.post.AnnotationPostModel;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface AnnotationController extends Controller {

    Mono<AnnotationModel> get(final UUID id) ;

    Mono<UUID> post(@RequestBody final AnnotationModel content);

    Mono<Void> update(final UUID id, final AnnotationModel content) ;

    Mono<UUID> delete(final AnnotationModel content);
}
