package com.xiaotian.tulic.digest;

import com.xiaotian.tulic.run.ProgressInfoTools;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

public class MD5DigestToolsTest {

    @Test
    public void digestAsHex() {
        int count = 10;
        int times = 1000000;
        String[] sample = new String[count];
        sample[0] = MD5DigestTools.digestAsHex("0");
        sample[1] = MD5DigestTools.digestAsHex("1");
        sample[2] = MD5DigestTools.digestAsHex("2");
        sample[3] = MD5DigestTools.digestAsHex("3");
        sample[4] = MD5DigestTools.digestAsHex("4");
        sample[5] = MD5DigestTools.digestAsHex("5");
        sample[6] = MD5DigestTools.digestAsHex("6");
        sample[7] = MD5DigestTools.digestAsHex("7");
        sample[8] = MD5DigestTools.digestAsHex("8");
        sample[9] = MD5DigestTools.digestAsHex("9");

        String[] result = new String[count];
        for (int i = 0; i < times; i++) {
            CompletableFuture[] completableFutures = new CompletableFuture[count];
            completableFutures[0] = CompletableFuture.runAsync(() -> result[0] = MD5DigestTools.digestAsHex("0"));
            completableFutures[1] = CompletableFuture.runAsync(() -> result[1] = MD5DigestTools.digestAsHex("1"));
            completableFutures[2] = CompletableFuture.runAsync(() -> result[2] = MD5DigestTools.digestAsHex("2"));
            completableFutures[3] = CompletableFuture.runAsync(() -> result[3] = MD5DigestTools.digestAsHex("3"));
            completableFutures[4] = CompletableFuture.runAsync(() -> result[4] = MD5DigestTools.digestAsHex("4"));
            completableFutures[5] = CompletableFuture.runAsync(() -> result[5] = MD5DigestTools.digestAsHex("5"));
            completableFutures[6] = CompletableFuture.runAsync(() -> result[6] = MD5DigestTools.digestAsHex("6"));
            completableFutures[7] = CompletableFuture.runAsync(() -> result[7] = MD5DigestTools.digestAsHex("7"));
            completableFutures[8] = CompletableFuture.runAsync(() -> result[8] = MD5DigestTools.digestAsHex("8"));
            completableFutures[9] = CompletableFuture.runAsync(() -> result[9] = MD5DigestTools.digestAsHex("9"));
            CompletableFuture.allOf(completableFutures).join();
            System.out.println(ProgressInfoTools.format(times, i + 1));

            for (int j = 0; j < result.length; j++) {
                if (!sample[j].equals(result[j])) {
                    throw new RuntimeException("");
                }
            }
        }
    }
}