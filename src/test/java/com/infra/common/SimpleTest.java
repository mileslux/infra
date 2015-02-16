package com.infra.common;

import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * Created by mileslux on 2/16/15.
 */

@Test
public class SimpleTest {
    private static final String WOOF = "Woof";

    public void shouldReturnWoof() {
        Assert.assertEquals(Woofer.woof(), WOOF);
    }
}
