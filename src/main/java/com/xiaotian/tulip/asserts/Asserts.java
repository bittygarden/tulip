package com.xiaotian.tulip.asserts;

import java.util.Objects;

/**
 * @author sunfeilong [ 2020/12/17 10:58 ]
 */
public class Asserts {

    public static void assertNotNull(Object o, String message) {
        if (Objects.isNull(o)) {
            throw new IllegalArgumentException(message);
        }
    }
}
