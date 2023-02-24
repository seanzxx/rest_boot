package com.edriving.commons.rest.boot.admin;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeartbeatImplSimpleTest {

    @Test
    public void probe() {
        Assert.assertEquals("I am alive", new HeartbeatImplSimple().probe());
    }
}