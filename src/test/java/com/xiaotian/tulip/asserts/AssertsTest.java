package com.xiaotian.tulip.asserts;

import org.junit.Test;

public class AssertsTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNull() {
        Asserts.assertNotNull(null, "object is null");
    }

    @Test
    public void testNotNull() {
        Asserts.assertNotNull(true, "");
        Asserts.assertNotNull(false, "");

        Asserts.assertNotNull(-1, "");
        Asserts.assertNotNull(0, "");
        Asserts.assertNotNull(1, "");

        Asserts.assertNotNull("", "");
        Asserts.assertNotNull("java", "");

        Asserts.assertNotNull(new Object(), "");
    }

}