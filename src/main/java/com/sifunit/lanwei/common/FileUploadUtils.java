package com.sifunit.lanwei.common;

import java.io.File;

public class FileUploadUtils {
    public static String UploadPath = "E:/upload/";
    public static String MappingPath = "/upload/";
    static {
        File path = new File(UploadPath);
        if (!path.exists()) {
            path.mkdirs();
        }
    }
}
