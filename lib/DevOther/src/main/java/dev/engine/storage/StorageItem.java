package dev.engine.storage;

import android.graphics.Bitmap;
import android.net.Uri;

/**
 * detail: Storage Item Params
 * @author Ttt
 * <pre>
 *     {@link #mFolder} 只需要文件夹名字
 *     是因为 Android 适配 {@link android.provider.MediaStore} 传入 RELATIVE_PATH 使用
 *     <p></p>
 *     {@link #mFilePath} 只会在内部存储时使用
 *     属于内部存储时, 完整路径为 filePath + folder + fileName
 *     <p></p>
 *     可传入输出 Uri 或通过拼接路径创建 Uri 二选一
 * </pre>
 */
public class StorageItem
        extends IStorageEngine.EngineItem {

    // =======
    // = 通用 =
    // =======

    // 存储文件名
    private String mFileName;
    // 存储文件夹 ( 不包含完整路径, 就文件夹名, 不传则会存储在对应路径文件根目录 )
    private String mFolder; // 可以传入, 如: /Dev/Material
    // 存储路径 ( 不包含文件名, 纯路径 ) 只会在内部存储时使用
    private String mFilePath;
    // 资源类型
    private String mMimeType;

    // 输出 Uri
    private Uri mOutputUri;

    // ==============================================
    // = Storage DevSource 属于 Bitmap、Drawable 使用 =
    // ==============================================

    // 图片格式
    private Bitmap.CompressFormat mFormat  = Bitmap.CompressFormat.PNG;
    // 图片质量
    private int                   mQuality = 100;

    // =============
    // = 对外公开方法 =
    // =============

    public String getFileName() {
        return mFileName;
    }

    public StorageItem setFileName(String fileName) {
        this.mFileName = fileName;
        return this;
    }

    public String getFolder() {
        return mFolder;
    }

    public StorageItem setFolder(String folder) {
        this.mFolder = folder;
        return this;
    }

    public String getFilePath() {
        return mFilePath;
    }

    public StorageItem setFilePath(String filePath) {
        this.mFilePath = filePath;
        return this;
    }

    public String getMimeType() {
        return mMimeType;
    }

    public StorageItem setMimeType(String mimeType) {
        this.mMimeType = mimeType;
        return this;
    }

    public Uri getOutputUri() {
        return mOutputUri;
    }

    public StorageItem setOutputUri(Uri outputUri) {
        this.mOutputUri = outputUri;
        return this;
    }

    public Bitmap.CompressFormat getFormat() {
        return mFormat;
    }

    public StorageItem setFormat(Bitmap.CompressFormat format) {
        this.mFormat = format;
        return this;
    }

    public int getQuality() {
        return mQuality;
    }

    public StorageItem setQuality(int quality) {
        this.mQuality = quality;
        return this;
    }
}