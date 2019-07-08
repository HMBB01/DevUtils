package dev.utils.app;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;

import dev.DevUtils;
import dev.utils.LogPrintUtils;

/**
 * detail: Android Manifest 工具类
 * @author Ttt
 */
public final class ManifestUtils {

    private ManifestUtils() {
    }

    // 日志 TAG
    private static final String TAG = ManifestUtils.class.getSimpleName();

    /**
     * 获取 Application meta Data
     * @param metaKey meta Key
     * @return Application meta Data
     */
    public static String getMetaData(final String metaKey) {
        try {
            return getMetaData(DevUtils.getContext().getPackageName(), metaKey);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getMetaData");
        }
        return null;
    }

    /**
     * 获取 Application meta Data
     * @param packageName 应用包名
     * @param metaKey     meta Key
     * @return Application meta Data
     */
    public static String getMetaData(final String packageName, final String metaKey) {
        try {
            ApplicationInfo appInfo = DevUtils.getContext().getPackageManager().getApplicationInfo(packageName, PackageManager.GET_META_DATA);
            return appInfo.metaData.getString(metaKey);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getMetaData");
        }
        return null;
    }

    // =

    /**
     * 获取 Activity meta Data
     * @param clazz   Activity.class
     * @param metaKey meta Key
     * @return Activity meta Data
     */
    public static String getMetaDataInActivity(final Class<?> clazz, final String metaKey) {
        try {
            return getMetaDataInActivity(DevUtils.getContext().getPackageName(), clazz.getCanonicalName(), metaKey);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getMetaDataInActivity");
        }
        return null;
    }

    /**
     * 获取 Activity meta Data
     * @param name    完整路径名 package.name => class.getCanonicalName()
     * @param metaKey meta Key
     * @return Activity meta Data
     */
    public static String getMetaDataInActivity(final String name, final String metaKey) {
        try {
            return getMetaDataInActivity(DevUtils.getContext().getPackageName(), name, metaKey);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getMetaDataInActivity");
        }
        return null;
    }

    /**
     * 获取 Activity meta Data
     * @param packageName 应用包名
     * @param name        完整路径名 package.name => class.getCanonicalName()
     * @param metaKey     meta Key
     * @return Activity meta Data
     */
    public static String getMetaDataInActivity(final String packageName, final String name, final String metaKey) {
        try {
            ComponentName componentName = new ComponentName(packageName, name);
            ActivityInfo activityInfo = DevUtils.getContext().getPackageManager().getActivityInfo(componentName, PackageManager.GET_META_DATA);
            return activityInfo.metaData.getString(metaKey);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getMetaDataInActivity");
        }
        return null;
    }

    // =

    /**
     * 获取 Service meta Data
     * @param clazz   Service.class
     * @param metaKey meta Key
     * @return Service meta Data
     */
    public static String getMetaDataInService(final Class<?> clazz, final String metaKey) {
        try {
            return getMetaDataInService(DevUtils.getContext().getPackageName(), clazz.getCanonicalName(), metaKey);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getMetaDataInService");
        }
        return null;
    }

    /**
     * 获取 Service meta Data
     * @param name    完整路径名 package.name => class.getCanonicalName()
     * @param metaKey meta Key
     * @return Service meta Data
     */
    public static String getMetaDataInService(final String name, final String metaKey) {
        try {
            return getMetaDataInService(DevUtils.getContext().getPackageName(), name, metaKey);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getMetaDataInService");
        }
        return null;
    }

    /**
     * 获取 Service meta Data
     * @param packageName 应用包名
     * @param name        完整路径名 package.name => class.getCanonicalName()
     * @param metaKey     meta Key
     * @return Service meta Data
     */
    public static String getMetaDataInService(final String packageName, final String name, final String metaKey) {
        try {
            ComponentName componentName = new ComponentName(packageName, name);
            ServiceInfo serviceInfo = DevUtils.getContext().getPackageManager().getServiceInfo(componentName, PackageManager.GET_META_DATA);
            return serviceInfo.metaData.getString(metaKey);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getMetaDataInService");
        }
        return null;
    }

    // =

    /**
     * 获取 Receiver meta Data
     * @param clazz   Receiver.class
     * @param metaKey meta Key
     * @return Receiver meta Data
     */
    public static String getMetaDataInReceiver(final Class<?> clazz, final String metaKey) {
        try {
            return getMetaDataInReceiver(DevUtils.getContext().getPackageName(), clazz.getCanonicalName(), metaKey);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getMetaDataInReceiver");
        }
        return null;
    }

    /**
     * 获取 Receiver meta Data
     * @param name    完整路径名 package.name => class.getCanonicalName()
     * @param metaKey meta Key
     * @return Receiver meta Data
     */
    public static String getMetaDataInReceiver(final String name, final String metaKey) {
        try {
            return getMetaDataInReceiver(DevUtils.getContext().getPackageName(), name, metaKey);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getMetaDataInReceiver");
        }
        return null;
    }

    /**
     * 获取 Receiver meta Data
     * @param packageName 应用包名
     * @param name        完整路径名 package.name => class.getCanonicalName()
     * @param metaKey     meta Key
     * @return Receiver meta Data
     */
    public static String getMetaDataInReceiver(final String packageName, final String name, final String metaKey) {
        try {
            ComponentName componentName = new ComponentName(packageName, name);
            ActivityInfo receiverInfo = DevUtils.getContext().getPackageManager().getReceiverInfo(componentName, PackageManager.GET_META_DATA);
            return receiverInfo.metaData.getString(metaKey);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getMetaDataInReceiver");
        }
        return null;
    }

    // =

    /**
     * 获取 ContentProvider meta Data
     * @param clazz   ContentProvider.class
     * @param metaKey meta Key
     * @return ContentProvider meta Data
     */
    public static String getMetaDataInProvider(final Class<?> clazz, final String metaKey) {
        try {
            return getMetaDataInProvider(DevUtils.getContext().getPackageName(), clazz.getCanonicalName(), metaKey);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getMetaDataInProvider");
        }
        return null;
    }

    /**
     * 获取 ContentProvider meta Data
     * @param name    完整路径名 package.name => class.getCanonicalName()
     * @param metaKey meta Key
     * @return ContentProvider meta Data
     */
    public static String getMetaDataInProvider(final String name, final String metaKey) {
        try {
            return getMetaDataInProvider(DevUtils.getContext().getPackageName(), name, metaKey);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getMetaDataInProvider");
        }
        return null;
    }

    /**
     * 获取 ContentProvider meta Data
     * @param packageName 应用包名
     * @param name        完整路径名 package.name => class.getCanonicalName()
     * @param metaKey     meta Key
     * @return ContentProvider meta Data
     */
    public static String getMetaDataInProvider(final String packageName, final String name, final String metaKey) {
        try {
            ComponentName componentName = new ComponentName(packageName, name);
            ProviderInfo providerInfo = DevUtils.getContext().getPackageManager().getProviderInfo(componentName, PackageManager.GET_META_DATA);
            return providerInfo.metaData.getString(metaKey);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getMetaDataInProvider");
        }
        return null;
    }

    // =

    /**
     * 获取 App 版本信息
     * @return 0 = versionName, 1 = versionCode
     */
    public static String[] getAppVersion() {
        try {
            PackageManager pm = DevUtils.getContext().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(DevUtils.getContext().getPackageName(), PackageManager.GET_SIGNATURES);
            if (pi != null) {
                String versionName = pi.versionName == null ? "null" : pi.versionName;
                String versionCode = pi.versionCode + "";
                return new String[]{versionName, versionCode};
            }
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getAppVersion");
        }
        return null;
    }

    /**
     * 获取 App versionCode
     * @return App versionCode
     */
    public static int getAppVersionCode() {
        try {
            PackageManager pm = DevUtils.getContext().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(DevUtils.getContext().getPackageName(), PackageManager.GET_SIGNATURES);
            if (pi != null) {
                return pi.versionCode;
            }
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getAppVersionCode");
        }
        return -1;
    }

    /**
     * 获取 App versionName
     * @return App versionName
     */
    public static String getAppVersionName() {
        try {
            PackageManager pm = DevUtils.getContext().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(DevUtils.getContext().getPackageName(), PackageManager.GET_SIGNATURES);
            if (pi != null) {
                return pi.versionName;
            }
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getAppVersionName");
        }
        return null;
    }

    // =

    /**
     * 获取 App versionCode
     * @param packageName 应用包名
     * @return App versionCode
     */
    public static int getAppVersionCode(final String packageName) {
        if (isSpace(packageName)) return -1;
        try {
            PackageManager pm = DevUtils.getContext().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
            return pi == null ? -1 : pi.versionCode;
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getAppVersionCode - " + packageName);
            return -1;
        }
    }

    /**
     * 获取 App versionName
     * @param packageName 应用包名
     * @return App versionName
     */
    public static String getAppVersionName(final String packageName) {
        if (isSpace(packageName)) return null;
        try {
            PackageManager pm = DevUtils.getContext().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
            return pi == null ? null : pi.versionName;
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getAppVersionName - " + packageName);
            return null;
        }
    }

    // ======================
    // = 其他工具类实现代码 =
    // ======================

    // ===============
    // = StringUtils =
    // ===============

    /**
     * 判断字符串是否为 null 或全为空白字符
     * @param str 待校验字符串
     * @return {@code true} yes, {@code false} no
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