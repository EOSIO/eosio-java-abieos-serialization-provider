package one.block.eosiojavaabieosserializationprovider;

import java.lang.reflect.Field;

public final class NativeLibsLoaderUtil {
    private static final String JAVA_LIBRARY_PATH = "java.library.path";
    private static final String SYS_PATHS = "sys_paths";

    static void addLibsToJavaLibraryPath(final String tmpDirName, final boolean isProjectPath) {
        try {
            String fullPath = isProjectPath ? System.getProperty("user.dir") + tmpDirName : tmpDirName;
            System.setProperty(JAVA_LIBRARY_PATH, fullPath);
            final Field fieldSysPath = ClassLoader.class.getDeclaredField(SYS_PATHS);
            fieldSysPath.setAccessible(true);
            fieldSysPath.set(null, null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
