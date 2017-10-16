package com.vicboma.fwk.spring.boot.controller.src;

import com.vicboma.fwk.spring.boot.controller.api.AnnotationController;
import com.vicboma.fwk.spring.boot.model.AnnotationModel;
import com.vicboma.fwk.spring.boot.model.post.AnnotationPostModel;
import com.vicboma.fwk.spring.boot.service.api.ServiceAnnotation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;


@RestController
public class AnnotationControllerImpl implements AnnotationController {

    private ServiceAnnotation serviceAnnotation;

    public AnnotationControllerImpl(ServiceAnnotation _serviceAnnotation)  {
        this.serviceAnnotation = _serviceAnnotation;
        this.getLogger().info("Initialize ServiceAnnotation "+_serviceAnnotation);
    }


    @Override
    @GetMapping("/api/annotation/{id}/get")
    public Mono<AnnotationModel> get(@PathVariable UUID id) {
        return null;
    }

    @Override
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/api/annotation/post")
    public Mono<UUID> post(@RequestBody AnnotationModel content) {
        return serviceAnnotation.post(Mono.justOrEmpty(content));
    }

    @Override
    @PutMapping("/api/annotation/{id}/put")
    public Mono<Void> update(UUID id, AnnotationModel content) {
        return null;
    }

    @Override
    @DeleteMapping("/api/annotation/{id}/delete")
    public Mono<UUID> delete(AnnotationModel content) {
        return null;
    }
}