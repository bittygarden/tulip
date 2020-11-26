package com.xiaotian.tulic.compress.lz4;

import com.xiaotian.tulic.compress.Compress;
import com.xiaotian.tulic.compress.CompressData;
import com.xiaotian.tulic.compress.Decompress;
import com.xiaotian.tulic.radix.NumberBytesConverter;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;

import java.util.Arrays;


/**
 * LZ4 压缩 注重压缩和解压速度，压缩率可能不高
 *
 * @author sunfeilong [2020/11/25 12:00]
 */
public class LZ4 implements Compress, Decompress {

    private static final int APPEND_LENGTH = 4;


    private static final LZ4Factory LZ4FACTORY = LZ4Factory.fastestJavaInstance();


    @Override
    public CompressData compress(CompressData data) {
        LZ4Compressor lz4Compressor = LZ4FACTORY.highCompressor();
        int maxCompressedLength = lz4Compressor.maxCompressedLength(data.length());
        int maxLengthWithAppend = maxCompressedLength + APPEND_LENGTH;

        byte[] result = new byte[maxLengthWithAppend];
        int compressLength = lz4Compressor.compress(data.data(), 0, data.length(), result, 4, maxCompressedLength);
        addLengthToHeader(result, data.length());
        return CompressData.from(Arrays.copyOfRange(result, 0, compressLength + APPEND_LENGTH));
    }

    @Override
    public CompressData decompress(CompressData data) {
        int originDataLength = readLengthFromHeader(data.data());
        byte[] result = new byte[originDataLength];
        LZ4FACTORY.fastDecompressor().decompress(data.data(), APPEND_LENGTH, result, 0, originDataLength);
        return CompressData.from(result);
    }

    private void addLengthToHeader(byte[] result, int length) {
        byte[] numberByte = NumberBytesConverter.intToByte(length);
        result[0] = numberByte[0];
        result[1] = numberByte[1];
        result[2] = numberByte[2];
        result[3] = numberByte[3];
    }

    private int readLengthFromHeader(byte[] result) {
        return NumberBytesConverter.byteToInt(new byte[]{result[0], result[1], result[2], result[3]});
    }
}
