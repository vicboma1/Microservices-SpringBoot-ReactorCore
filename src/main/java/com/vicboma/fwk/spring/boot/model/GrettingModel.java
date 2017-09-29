package com.vicboma.fwk.spring.boot.model;

public class GrettingModel {

    public String hi;

    public static GrettingModel create(String name) {
        return new GrettingModel(name);
    }

    GrettingModel(String name) {
        this.hi = name;
    }

    public String getHi(){
        return this.hi;
    }
}
