package com.xiaotian.tulic.compress;

/**
 * 数据解压接口
 *
 * @author sunfeilong [2020/11/25 10:57]
 */
public interface Decompress {

    /**
     * 数据压缩结果
     *
     * @param data 压缩后的数据
     * @return 解压结果
     */
    CompressData decompress(CompressData data);
}
