package com.vicboma.fwk.spring.boot.model;

public class GrettingModel {

    private String hi;

    public static GrettingModel create() {
        return new GrettingModel();
    }

    GrettingModel() {

    }

    public String getHi(){
        return this.hi;
    }

    public GrettingModel setHi(String hi) {
        this.hi = hi;
        return this;
    }
}
