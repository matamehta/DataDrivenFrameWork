package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

    public static String getProtocol(){

        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream("/Users/sakodali/Sandbox/VoucherCodes/src/test/resources/vouchercodes.properties"));

            // System.out.println(prop.getProperty("protocol"));

        } catch (IOException ex) {
            ex.printStackTrace();

        }
        return (prop.getProperty("protocol"));
    }
}
