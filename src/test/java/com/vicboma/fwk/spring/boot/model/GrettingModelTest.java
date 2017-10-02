package com.vicboma.fwk.spring.boot.model;

import org.junit.Assert;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class GrettingModelTest {

    final static String expected = "expected";

    @Test
    public void _class() throws Exception{
        final GrettingModel grettingModel = GrettingModel.create().setHi(expected);
        Assert.assertEquals(grettingModel.getClass(),GrettingModel.class);
    }

    @Test
    public  void create() throws Exception{
        final GrettingModel grettingModel1 = GrettingModel.create().setHi(expected);
        final GrettingModel grettingModel2 = GrettingModel.create().setHi(expected);

        Assert.assertNotEquals(grettingModel1,grettingModel2);
    }

    @Test
    public void getHi() throws Exception{

        final GrettingModel grettingModel = GrettingModel.create().setHi(expected);
        final String result = grettingModel.getHi();

        Assert.assertEquals(expected,result);

    }

    @Test
    public void getHiDefault() throws Exception{

        final GrettingModel grettingModel = GrettingModel.create().setHi(expected);
        final String result = grettingModel.getHi();

        Assert.assertEquals(expected,result);

    }

}