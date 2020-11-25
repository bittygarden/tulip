package com.xiaotian.tulic.radix;

/**
 * 数据自己转换
 *
 * @author sunfeilong [2020/11/25 16:04]
 */
public class NumberBytesConverter {

    private static final int EIGHT = 0xff;
    private static final int INT_BYTES_LENGTH = 4;

    public static int byteToInt(byte[] data) {
        if (data == null || data.length != INT_BYTES_LENGTH) {
            throw new IllegalArgumentException("NumberBytesConverter bytes length must equal: " + INT_BYTES_LENGTH);
        }
        int result = 0;
        result = result | (data[0] & EIGHT) << 24;
        result = result | (data[1] & EIGHT) << 16;
        result = result | (data[2] & EIGHT) << 8;
        result = result | (data[3] & EIGHT);
        return result;
    }

    public static byte[] intToByte(int number) {
        byte[] result = new byte[4];
        byte first = (byte) ((number >>> 24) & EIGHT);
        byte second = (byte) ((number >>> 16) & EIGHT);
        byte third = (byte) ((number >>> 8) & EIGHT);
        byte fourth = (byte) ((number) & EIGHT);
        result[0] = first;
        result[1] = second;
        result[2] = third;
        result[3] = fourth;
        return result;
    }
}
