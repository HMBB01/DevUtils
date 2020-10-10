package dev.utils.common.file;

import java.io.File;

/**
 * detail: 文件分片信息 Item
 * @author Ttt
 */
public class FilePartItem {

    // 分片索引
    public final int  partIndex;
    // 分片总数
    public final int  partCount;
    // 分片总字节
    public final long partByteLength;
    // 原始文件总字节
    public final long fileByteLength;
    // 分片字节开始索引
    public final long start;
    // 分片字节结束索引
    public final long end;

    public FilePartItem(int partIndex, int partCount, long partByteLength, long fileByteLength, long start, long end) {
        this.partIndex = partIndex;
        this.partCount = partCount;
        this.partByteLength = partByteLength;
        this.fileByteLength = fileByteLength;
        this.start = start;
        this.end = end;
    }

    // ===============
    // = 对外公开方法 =
    // ===============

    /**
     * 获取分片文件名 ( 后缀索引拼接 )
     * @param fileName 原始文件名
     * @return 分片文件名
     */
    public String getPartName(final String fileName) {
        return FilePartUtils.getPartName(fileName, partIndex);
    }

    /**
     * 判断是否 First Item
     * @return {@code true} yes, {@code false} no
     */
    public boolean isFirstItem() {
        return partIndex == 0;
    }

    /**
     * 判断是否 Last Item
     * @return {@code true} yes, {@code false} no
     */
    public boolean isLastItem() {
        return partIndex + 1 == partCount;
    }

    /**
     * 是否只有一个分片文件
     * @return {@code true} yes, {@code false} no
     */
    public boolean isOnlyOne() {
        return partCount == 1;
    }

    // ===========
    // = 文件拆分 =
    // ===========

    /**
     * 文件拆分
     * @param filePath 文件路径
     * @return 指定位置数据
     */
    public byte[] fileSplit(final String filePath) {
        return FilePartUtils.fileSplit(filePath, this);
    }

    /**
     * 文件拆分
     * @param file 文件
     * @return 指定位置数据
     */
    public byte[] fileSplit(final File file) {
        return FilePartUtils.fileSplit(file, this);
    }
}