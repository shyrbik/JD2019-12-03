package by.it.rumiantcau.jd01_14;

import java.io.File;

public class Helper {

    public static String getPath(String fileName, Class<?> aClass) {
        String root = System.getProperty("user.dir");
        String strPackage = aClass.getName().replace(aClass.getSimpleName(), "");
        String path = root + File.separator + "src" + File.separator + strPackage.replace(".", File.separator);
        fileName = path + fileName;
        return fileName;
    }

}
