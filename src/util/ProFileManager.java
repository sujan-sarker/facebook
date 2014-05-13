package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * domain.User: sujan.sarkar
 * Date: 4/28/14
 * Time: 12:49 PM
 * To change this template use File | Settings | File Templates.
 */



public class ProFileManager {
    private static InputStream fileInputStream;
    private static Properties properties;

    public static Properties loadProperties(String fileUrl) throws IOException {
        fileInputStream = new FileInputStream(fileUrl);
        properties = new Properties();
        properties.load(fileInputStream);
        close();
        return properties;
    }

    public static void close() throws IOException {
        fileInputStream.close();
    }

}
