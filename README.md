# Microservices with Spring Boot v2.0 & Reactor Core v3.1.0

Sample


![](https://img.shields.io/badge/build-success-greenligth.svg)  ![](https://img.shields.io/badge/Maven-4.0.0-blue.svg)  ![](https://img.shields.io/badge/Java-1.8-blue.svg)  ![](https://img.shields.io/badge/SpringBoot-2.00-blue.svg)  ![](https://img.shields.io/badge/ReactorCore-3.1.0-yellow.svg)  ![](https://img.shields.io/badge/JUnit-4.10-orange.svg)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=vicboma1_Microservices-SpringBoot-ReactorCore&metric=alert_status)](https://sonarcloud.io/dashboard/index/vicboma1_Microservices-SpringBoot-ReactorCore)

## Api - /

```
    /**
     * @input http://localhost:8080
     * @return {"helloWorld":"Hello World!"}
     */
     @GetMapping("/")
     Mono<HelloWorldModel> home();
     
```

## Api - hi

```
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

```
