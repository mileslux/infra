package com.infra.asdf.application;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WooferTest {

    @Test
    public void testWoof() throws Exception {
        Assert.assertEquals(Woofer.woof(), "Woof");
    }
}