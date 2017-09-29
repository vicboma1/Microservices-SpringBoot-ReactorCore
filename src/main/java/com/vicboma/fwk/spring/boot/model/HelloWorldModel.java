package com.vicboma.fwk.spring.boot.model;

public class HelloWorldModel {

    public static final String HELLO_WORLD = "Hello World!";

    private String helloWorld;

    public static HelloWorldModel create(String value){
        return new HelloWorldModel(value);
    }

    public HelloWorldModel(String value){ this.helloWorld = value;}

    public String getHelloWorld() { return this.helloWorld; }
}