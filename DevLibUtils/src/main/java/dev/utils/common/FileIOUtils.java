package dev.utils.common;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import dev.utils.JCLogUtils;

/**
 * detail: 文件IO流工具类
 * @author Ttt
 */
public final class FileIOUtils {

    private FileIOUtils() {
    }

    // 日志 TAG
    private static final String TAG = FileIOUtils.class.getSimpleName();
    // 换行符
    private static final String NEW_LINE_STR = System.getProperty("line.separator");
    // 缓存大小
    private static int sBufferSize = 8192;

    /**
     * 设置缓冲区的大小, 默认大小等于 8192 字节
     * @param bufferSize
     */
    public static void setBufferSize(final int bufferSize) {
        sBufferSize = bufferSize;
    }

    /**
     * 通过输入流写入文件
     * @param filePath
     * @param is
     * @return true : success, false : fail
     */
    public static boolean writeFileFromIS(final String filePath, final InputStream is) {
        return writeFileFromIS(getFileByPath(filePath), is, false);
    }

    /**
     * 通过输入流写入文件
     * @param filePath
     * @param is
     * @param append
     * @return true : success, false : fail
     */
    public static boolean writeFileFromIS(final String filePath, final InputStream is, final boolean append) {
        return writeFileFromIS(getFileByPath(filePath), is, append);
    }

    /**
     * 通过输入流写入文件
     * @param file
     * @param is
     * @return true : success, false : fail
     */
    public static boolean writeFileFromIS(final File file, final InputStream is) {
        return writeFileFromIS(file, is, false);
    }

    /**
     * 通过输入流写入文件
     * @param file
     * @param is
     * @param append
     * @return true : success, false : fail
     */
    public static boolean writeFileFromIS(final File file, final InputStream is, final boolean append) {
        if (!createOrExistsFile(file) || is == null) return false;
        OutputStream os = null;
        try {
            os = new BufferedOutputStream(new FileOutputStream(file, append));
            byte data[] = new byte[sBufferSize];
            int len;
            while ((len = is.read(data, 0, sBufferSize)) != -1) {
                os.write(data, 0, len);
            }
            return true;
        } catch (IOException e) {
            JCLogUtils.eTag(TAG, e, "writeFileFromIS");
            return false;
        } finally {
            CloseUtils.closeIO(is, os);
        }
    }

    /**
     * 通过字节流写入文件
     * @param filePath
     * @param bytes
     * @return true : success, false : fail
     */
    public static boolean writeFileFromBytesByStream(final String filePath, final byte[] bytes) {
        return writeFileFromBytesByStream(getFileByPath(filePath), bytes, false);
    }

    /**
     * 通过字节流写入文件
     * @param filePath
     * @param bytes
     * @param append
     * @return true : success, false : fail
     */
    public static boolean writeFileFromBytesByStream(final String filePath, final byte[] bytes, final boolean append) {
        return writeFileFromBytesByStream(getFileByPath(filePath), bytes, append);
    }

    /**
     * 通过字节流写入文件
     * @param file
     * @param bytes
     * @return true : success, false : fail
     */
    public static boolean writeFileFromBytesByStream(final File file, final byte[] bytes) {
        return writeFileFromBytesByStream(file, bytes, false);
    }

    /**
     * 通过字节流写入文件
     * @param file
     * @param bytes
     * @param append
     * @return true : success, false : fail
     */
    public static boolean writeFileFromBytesByStream(final File file, final byte[] bytes, final boolean append) {
        if (bytes == null || !createOrExistsFile(file)) return false;
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(file, append));
            bos.write(bytes);
            return true;
        } catch (IOException e) {
            JCLogUtils.eTag(TAG, e, "writeFileFromBytesByStream");
            return false;
        } finally {
            CloseUtils.closeIO(bos);
        }
    }

    /**
     * 通过 FileChannel 把字节流写入文件
     * @param filePath
     * @param bytes
     * @param isForce
     * @return true : success, false : fail
     */
    public static boolean writeFileFromBytesByChannel(final String filePath, final byte[] bytes, final boolean isForce) {
        return writeFileFromBytesByChannel(getFileByPath(filePath), bytes, false, isForce);
    }

    /**
     * 通过 FileChannel 把字节流写入文件
     * @param filePath
     * @param bytes
     * @param append
     * @param isForce
     * @return true : success, false : fail
     */
    public static boolean writeFileFromBytesByChannel(final String filePath, final byte[] bytes, final boolean append, final boolean isForce) {
        return writeFileFromBytesByChannel(getFileByPath(filePath), bytes, append, isForce);
    }

    /**
     * 通过 FileChannel 把字节流写入文件
     * @param file
     * @param bytes
     * @param isForce
     * @return true : success, false : fail
     */
    public static boolean writeFileFromBytesByChannel(final File file, final byte[] bytes, final boolean isForce) {
        return writeFileFromBytesByChannel(file, bytes, false, isForce);
    }

    /**
     * 通过 FileChannel 把字节流写入文件
     * @param file
     * @param bytes
     * @param append
     * @param isForce
     * @return true : success, false : fail
     */
    public static boolean writeFileFromBytesByChannel(final File file, final byte[] bytes, final boolean append, final boolean isForce) {
        if (bytes == null) return false;
        FileChannel fc = null;
        try {
            fc = new FileOutputStream(file, append).getChannel();
            fc.position(fc.size());
            fc.write(ByteBuffer.wrap(bytes));
            if (isForce) fc.force(true);
            return true;
        } catch (IOException e) {
            JCLogUtils.eTag(TAG, e, "writeFileFromBytesByChannel");
            return false;
        } finally {
            CloseUtils.closeIO(fc);
        }
    }

    /**
     * 通过 MappedByteBuffer 把字节流写入文件
     * @param filePath
     * @param bytes
     * @param isForce
     * @return true : success, false : fail
     */
    public static boolean writeFileFromBytesByMap(final String filePath, final byte[] bytes, final boolean isForce) {
        return writeFileFromBytesByMap(filePath, bytes, false, isForce);
    }

    /**
     * 通过 MappedByteBuffer 把字节流写入文件
     * @param filePath
     * @param bytes
     * @param append
     * @param isForce
     * @return true : success, false : fail
     */
    public static boolean writeFileFromBytesByMap(final String filePath, final byte[] bytes, final boolean append, final boolean isForce) {
        return writeFileFromBytesByMap(getFileByPath(filePath), bytes, append, isForce);
    }

    /**
     * 通过 MappedByteBuffer 把字节流写入文件
     * @param file
     * @param bytes
     * @param isForce
     * @return true : success, false : fail
     */
    public static boolean writeFileFromBytesByMap(final File file, final byte[] bytes, final boolean isForce) {
        return writeFileFromBytesByMap(file, bytes, false, isForce);
    }

    /**
     * 通过 MappedByteBuffer 把字节流写入文件
     * @param file
     * @param bytes
     * @param append
     * @param isForce
     * @return true : success, false : fail
     */
    public static boolean writeFileFromBytesByMap(final File file, final byte[] bytes, final boolean append, final boolean isForce) {
        if (bytes == null || !createOrExistsFile(file)) return false;
        FileChannel fc = null;
        try {
            fc = new FileOutputStream(file, append).getChannel();
            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, fc.size(), bytes.length);
            mbb.put(bytes);
            if (isForce) mbb.force();
            return true;
        } catch (IOException e) {
            JCLogUtils.eTag(TAG, e, "writeFileFromBytesByMap");
            return false;
        } finally {
            CloseUtils.closeIO(fc);
        }
    }

    /**
     * 通过字符串写入文件
     * @param filePath
     * @param content
     * @return true : success, false : fail
     */
    public static boolean writeFileFromString(final String filePath, final String content) {
        return writeFileFromString(getFileByPath(filePath), content, false);
    }

    /**
     * 通过字符串写入文件
     * @param filePath
     * @param content
     * @param append
     * @return true : success, false : fail
     */
    public static boolean writeFileFromString(final String filePath, final String content, final boolean append) {
        return writeFileFromString(getFileByPath(filePath), content, append);
    }

    /**
     * 通过字符串写入文件
     * @param file
     * @param content
     * @return true : success, false : fail
     */
    public static boolean writeFileFromString(final File file, final String content) {
        return writeFileFromString(file, content, false);
    }

    /**
     * 通过字符串写入文件
     * @param file
     * @param content
     * @param append
     * @return true : success, false : fail
     */
    public static boolean writeFileFromString(final File file, final String content, final boolean append) {
        if (file == null || content == null) return false;
        if (!createOrExistsFile(file)) return false;
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file, append));
            bw.write(content);
            return true;
        } catch (IOException e) {
            JCLogUtils.eTag(TAG, e, "writeFileFromString");
            return false;
        } finally {
            CloseUtils.closeIO(bw);
        }
    }

    // ==============
    // = 读写分界线 =
    // ==============

    /**
     * 读取文件内容, 返回换行 List
     * @param filePath
     * @return
     */
    public static List<String> readFileToList(final String filePath) {
        return readFileToList(getFileByPath(filePath), null);
    }

    /**
     * 读取文件内容, 返回换行 List
     * @param filePath
     * @param charsetName
     * @return
     */
    public static List<String> readFileToList(final String filePath, final String charsetName) {
        return readFileToList(getFileByPath(filePath), charsetName);
    }

    /**
     * 读取文件内容, 返回换行 List
     * @param file
     * @return
     */
    public static List<String> readFileToList(final File file) {
        return readFileToList(file, 0, 0x7FFFFFFF, null);
    }

    /**
     * 读取文件内容, 返回换行 List
     * @param file
     * @param charsetName
     * @return
     */
    public static List<String> readFileToList(final File file, final String charsetName) {
        return readFileToList(file, 0, 0x7FFFFFFF, charsetName);
    }

    /**
     * 读取文件内容, 返回换行 List
     * @param filePath
     * @param start
     * @param end
     * @return
     */
    public static List<String> readFileToList(final String filePath, final int start, final int end) {
        return readFileToList(getFileByPath(filePath), start, end, null);
    }

    /**
     * 读取文件内容, 返回换行 List
     * @param filePath
     * @param start
     * @param end
     * @param charsetName
     * @return
     */
    public static List<String> readFileToList(final String filePath, final int start, final int end, final String charsetName) {
        return readFileToList(getFileByPath(filePath), start, end, charsetName);
    }

    /**
     * 读取文件内容, 返回换行 List
     * @param file
     * @param start
     * @param end
     * @return
     */
    public static List<String> readFileToList(final File file, final int start, final int end) {
        return readFileToList(file, start, end, null);
    }

    /**
     * 读取文件内容, 返回换行 List
     * @param file
     * @param start
     * @param end
     * @param charsetName
     * @return
     */
    public static List<String> readFileToList(final File file, final int start, final int end, final String charsetName) {
        if (!isFileExists(file)) return null;
        if (start > end) return null;
        BufferedReader reader = null;
        try {
            String line;
            int curLine = 1;
            List<String> list = new ArrayList<>();
            if (isSpace(charsetName)) {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            } else {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charsetName));
            }
            while ((line = reader.readLine()) != null) {
                if (curLine > end) break;
                if (start <= curLine && curLine <= end) list.add(line);
                ++curLine;
            }
            return list;
        } catch (IOException e) {
            JCLogUtils.eTag(TAG, e, "readFileToList");
            return null;
        } finally {
            CloseUtils.closeIO(reader);
        }
    }

    /**
     * 读取文件内容, 返回字符串
     * @param filePath
     * @return
     */
    public static String readFileToString(final String filePath) {
        return readFileToString(getFileByPath(filePath), null);
    }

    /**
     * 读取文件内容, 返回字符串
     * @param filePath
     * @param charsetName
     * @return
     */
    public static String readFileToString(final String filePath, final String charsetName) {
        return readFileToString(getFileByPath(filePath), charsetName);
    }

    /**
     * 读取文件内容, 返回字符串
     * @param file
     * @return
     */
    public static String readFileToString(final File file) {
        return readFileToString(file, null);
    }

    /**
     * 读取文件内容, 返回字符串
     * @param file
     * @param charsetName
     * @return
     */
    public static String readFileToString(final File file, final String charsetName) {
        if (!isFileExists(file)) return null;
        BufferedReader reader = null;
        try {
            StringBuilder builder = new StringBuilder();
            if (isSpace(charsetName)) {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            } else {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charsetName));
            }
            String line;
            if ((line = reader.readLine()) != null) {
                builder.append(line);
                while ((line = reader.readLine()) != null) {
                    builder.append(NEW_LINE_STR).append(line);
                }
            }
            return builder.toString();
        } catch (IOException e) {
            JCLogUtils.eTag(TAG, e, "readFileToString");
            return null;
        } finally {
            CloseUtils.closeIO(reader);
        }
    }

    /**
     * 读取文件内容, 返回 byte[]
     * @param filePath
     * @return
     */
    public static byte[] readFileToBytesByStream(final String filePath) {
        return readFileToBytesByStream(getFileByPath(filePath));
    }

    /**
     * 读取文件内容, 返回 byte[]
     * @param file
     * @return
     */
    public static byte[] readFileToBytesByStream(final File file) {
        if (!isFileExists(file)) return null;
        FileInputStream fis = null;
        ByteArrayOutputStream os = null;
        try {
            fis = new FileInputStream(file);
            os = new ByteArrayOutputStream();
            byte[] b = new byte[sBufferSize];
            int len;
            while ((len = fis.read(b, 0, sBufferSize)) != -1) {
                os.write(b, 0, len);
            }
            return os.toByteArray();
        } catch (IOException e) {
            JCLogUtils.eTag(TAG, e, "readFileToBytesByStream");
            return null;
        } finally {
            CloseUtils.closeIO(fis, os);
        }
    }

    /**
     * 通过 FileChannel, 读取文件内容, 返回 byte[]
     * @param filePath
     * @return
     */
    public static byte[] readFileToBytesByChannel(final String filePath) {
        return readFileToBytesByChannel(getFileByPath(filePath));
    }

    /**
     * 通过 FileChannel, 读取文件内容, 返回 byte[]
     * @param file
     * @return
     */
    public static byte[] readFileToBytesByChannel(final File file) {
        if (!isFileExists(file)) return null;
        FileChannel fc = null;
        try {
            fc = new RandomAccessFile(file, "r").getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) fc.size());
            while (true) {
                if (!((fc.read(byteBuffer)) > 0)) break;
            }
            return byteBuffer.array();
        } catch (IOException e) {
            JCLogUtils.eTag(TAG, e, "readFileToBytesByChannel");
            return null;
        } finally {
            CloseUtils.closeIO(fc);
        }
    }

    /**
     * 通过 MappedByteBuffer, 读取文件内容, 返回 byte[]
     * @param filePath
     * @return
     */
    public static byte[] readFileToBytesByMap(final String filePath) {
        return readFileToBytesByMap(getFileByPath(filePath));
    }

    /**
     * 通过 MappedByteBuffer, 读取文件内容, 返回 byte[]
     * @param file
     * @return
     */
    public static byte[] readFileToBytesByMap(final File file) {
        if (!isFileExists(file)) return null;
        FileChannel fc = null;
        try {
            fc = new RandomAccessFile(file, "r").getChannel();
            int size = (int) fc.size();
            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, size).load();
            byte[] result = new byte[size];
            mbb.get(result, 0, size);
            return result;
        } catch (IOException e) {
            JCLogUtils.eTag(TAG, e, "readFileToBytesByMap");
            return null;
        } finally {
            CloseUtils.closeIO(fc);
        }
    }

    // =

    /**
     * 获取文件
     * @param filePath
     * @return
     */
    private static File getFileByPath(final String filePath) {
        return filePath != null ? new File(filePath) : null;
    }

    /**
     * 判断文件是否存在，不存在则判断是否创建成功
     * @param filePath 文件路径
     * @return true : 存在或创建成功, false : 不存在或创建失败
     */
    private static boolean createOrExistsFile(final String filePath) {
        return createOrExistsFile(getFileByPath(filePath));
    }

    /**
     * 判断文件是否存在，不存在则判断是否创建成功
     * @param file 文件
     * @return true : 存在或创建成功, false : 不存在或创建失败
     */
    private static boolean createOrExistsFile(final File file) {
        if (file == null) return false;
        // 如果存在，是文件则返回 true，是目录则返回 false
        if (file.exists()) return file.isFile();
        // 判断文件是否存在, 不存在则直接返回
        if (!createOrExistsDir(file.getParentFile())) return false;
        try {
            // 存在, 则返回新的路径
            return file.createNewFile();
        } catch (IOException e) {
            JCLogUtils.eTag(TAG, e, "createOrExistsFile");
            return false;
        }
    }

    /**
     * 判断目录是否存在，不存在则判断是否创建成功
     * @param file 文件
     * @return true : 存在或创建成功, false : 不存在或创建失败
     */
    private static boolean createOrExistsDir(final File file) {
        // 如果存在，是目录则返回 true，是文件则返回 false，不存在则返回是否创建成功
        return file != null && (file.exists() ? file.isDirectory() : file.mkdirs());
    }

    /**
     * 检查是否存在某个文件
     * @param file 文件路径
     * @return 是否存在文件
     */
    private static boolean isFileExists(final File file) {
        return file != null && file.exists();
    }

    /**
     * 判断字符串是否为 null 或全为空白字符
     * @param str 待校验字符串
     * @return
     */
    private static boolean isSpace(final String str) {
        if (str == null) return true;
        for (int i = 0, len = str.length(); i < len; ++i) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
