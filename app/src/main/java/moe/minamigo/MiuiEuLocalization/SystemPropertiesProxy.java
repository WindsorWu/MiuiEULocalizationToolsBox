package moe.minamigo.MiuiEuLocalization;

import android.content.Context;
import java.io.File;
import dalvik.system.DexFile;

public class SystemPropertiesProxy {
    private static final String SYSTEM_PROPERTIES_CLASS = "android.os.SystemProperties";

    private static Object call(String methodName, Class<?>[] parameterTypes, Object... args) throws Exception {
        Class<?> systemProperties = Class.forName(SYSTEM_PROPERTIES_CLASS);
        return systemProperties.getMethod(methodName, parameterTypes).invoke(null, args);
    }

    public static String get(Context context, String key) throws IllegalArgumentException {
        try {
            return (String) call("get", new Class[]{String.class}, key);
        } catch (IllegalArgumentException iAE) {
            throw iAE;
        } catch (Exception e) {
            return "";
        }
    }

    public static String get(Context context, String key, String def) throws IllegalArgumentException {
        try {
            return (String) call("get", new Class[]{String.class, String.class}, key, def);
        } catch (IllegalArgumentException iAE) {
            throw iAE;
        } catch (Exception e) {
            return def;
        }
    }

    public static Integer getInt(Context context, String key, int def) throws IllegalArgumentException {
        try {
            return (Integer) call("getInt", new Class[]{String.class, Integer.TYPE}, key, def);
        } catch (IllegalArgumentException iAE) {
            throw iAE;
        } catch (Exception e) {
            return Integer.valueOf(def);
        }
    }

    public static Long getLong(Context context, String key, long def) throws IllegalArgumentException {
        try {
            return (Long) call("getLong", new Class[]{String.class, Long.TYPE}, key, def);
        } catch (IllegalArgumentException iAE) {
            throw iAE;
        } catch (Exception e) {
            return Long.valueOf(def);
        }
    }

    public static Boolean getBoolean(Context context, String key, boolean def) throws IllegalArgumentException {
        try {
            return (Boolean) call("getBoolean", new Class[]{String.class, Boolean.TYPE}, key, def);
        } catch (IllegalArgumentException iAE) {
            throw iAE;
        } catch (Exception e) {
            return Boolean.valueOf(def);
        }
    }

    public static void set(Context context, String key, String val) throws IllegalArgumentException {
        try {
            new DexFile(new File("/system/app/Settings.apk"));
            context.getClassLoader();
            call("set", new Class[]{String.class, String.class}, key, val);
        } catch (IllegalArgumentException iAE) {
            throw iAE;
        } catch (Exception e) {
        }
    }
}
