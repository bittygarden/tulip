package com.xiaotian.tulic.compress;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;

/**
 * 压缩结果
 *
 * @author sunfeilong [2020/11/25 11:07]
 */
public class CompressData {

    private final byte[] data;

    public CompressData(byte[] data) {
        this.data = data;
    }

    /**
     * 获取原始数据
     *
     * @return 原始数据
     */
    public byte[] data() {
        return data;
    }

    public int length() {
        return data == null ? 0 : data.length;
    }

    /**
     * 数据转换为16进制
     *
     * @return 16进制数据
     */
    public String hex() {
        return Hex.encodeHexString(data);
    }

    /**
     * 数据转换为 base64 编码
     *
     * @return base64 编码
     */
    public String base64() {
        return new String(Base64.encodeBase64(data), StandardCharsets.UTF_8);
    }

    /**
     * 数据转换位字符串
     *
     * @return 字符串
     */
    public String string() {
        return new String(data, StandardCharsets.UTF_8);
    }

    public static CompressData from(byte[] data) {
        return new CompressData(data);
    }

    public static CompressData from(String data) {
        return from(data.getBytes(StandardCharsets.UTF_8));
    }

    public static CompressData fromHex(String data) throws DecoderException {
        return from(Hex.decodeHex(data));
    }

    public static CompressData fromBase64(String data) throws DecoderException {
        return from(Base64.decodeBase64(data));
    }
}
