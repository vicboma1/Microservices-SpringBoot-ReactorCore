package com.vicboma.fwk.spring.boot.controller.api;

import com.vicboma.fwk.spring.boot.model.GrettingModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

public interface GreetingController extends Controller {

    /**
     * @input http://localhost:8080/hi/vicboma
     * @param name
     * @return {"hi":"vicboma"}
     */
    @GetMapping("/hi/{name}")
    Mono<GrettingModel> hi(@PathVariable String name);

    /**
     * @input http://localhost:8080/hi/vicboma
     * @param name
     * @return {"hi":"vicboma"}
     */
    @GetMapping("/hi/{name}/delayDefault")
    Mono<GrettingModel> hiDelayDefault(@PathVariable String name);

    /**
     * @input http://localhost:8080/hi/vicboma/delay/3000
     * @param name
     * @param time
     * @return {"hi":"vicboma"}
     */
    @GetMapping("/hi/{name}/delay/{timeMS}")
    Mono<GrettingModel> hiDelayTime(@PathVariable String name, @PathVariable Long time);

    /**
     * @input http://localhost:8080/hi/vicboma/delay?timeMS=5000
     * @param name
     * @param timeMS
     * @return {"hi":"vicboma"}
     */
    @GetMapping("/hi/{name}/delay")
    Mono<GrettingModel> hiDelayTimeRequestParam(@PathVariable String name, @RequestParam Long timeMS);

}
