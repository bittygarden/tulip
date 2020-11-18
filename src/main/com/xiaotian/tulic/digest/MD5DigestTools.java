package com.xiaotian.tulic.digest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class MD5DigestTools {

    private static final ThreadLocal<DigestUtils> DIGEST = ThreadLocal.withInitial(() -> new DigestUtils(MessageDigestAlgorithms.MD5));

    public static String digestAsHex(String content) {
        return DIGEST.get().digestAsHex(content);
    }
}
