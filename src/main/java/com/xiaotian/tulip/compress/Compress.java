package com.xiaotian.tulip.compress;

import java.io.IOException;

/**
 * 数据压缩接口
 *
 * @author sunfeilong [2020/11/25 10:57]
 */
public interface Compress {

    /**
     * 压缩数据
     *
     * @param data 字节数据
     * @return 压缩结果
     * @throws IOException 当压缩出错时抛出
     */
    CompressData compress(CompressData data) throws IOException;
}
