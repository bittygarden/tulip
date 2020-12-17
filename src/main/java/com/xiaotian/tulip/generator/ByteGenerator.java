package com.xiaotian.tulip.generator;

/**
 * 字节数据生成器
 *
 * @author sunfeilong [2020/11/26 15:27]
 */
public class ByteGenerator {

    private static final byte ONE_BYTE = 'a';

    public static byte oneByte() {
        return ONE_BYTE;
    }

    public static byte[] bytes(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("length must grater than 0");
        }
        byte[] result = new byte[length];
        for (int i = 0; i < length; i++) {
            result[i] = ONE_BYTE;
        }
        return result;
    }

}
