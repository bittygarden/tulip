package com.xiaotian.tulip.compress.snappy;

import com.xiaotian.tulip.compress.Compress;
import com.xiaotian.tulip.compress.CompressData;
import com.xiaotian.tulip.compress.Decompress;

import java.io.IOException;

/**
 * snappy 基于LZ77，注重压缩和解压速度。
 *
 * @author sunfeilong [2020/11/26 14:57]
 */
public class Snappy implements Compress, Decompress {

    @Override
    public CompressData compress(CompressData data) throws IOException {
        return CompressData.from(org.xerial.snappy.Snappy.compress(data.data()));
    }

    @Override
    public CompressData decompress(CompressData data) throws IOException {
        return CompressData.from(org.xerial.snappy.Snappy.uncompress(data.data()));
    }
}
