package com.vicboma.fwk.spring.boot.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class GrettingModelTest {

    final static String expected = "expected";

    @Test
    void _class() {
        final GrettingModel grettingModel = GrettingModel.create(expected);
        Assert.assertEquals(grettingModel.getClass(),GrettingModel.class);
    }

    @Test
    void create() {
        final GrettingModel grettingModel1 = GrettingModel.create(expected);
        final GrettingModel grettingModel2 = GrettingModel.create(expected);

        Assert.assertNotEquals(grettingModel1,grettingModel2);
    }

    @Test
    void getHi() {

        final GrettingModel grettingModel = GrettingModel.create(expected);
        final String result = grettingModel.getHi();

        Assert.assertEquals(expected,result);

    }

}