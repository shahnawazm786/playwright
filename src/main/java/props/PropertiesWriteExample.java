package props;

import java.io.*;
import java.util.Properties;

public class PropertiesWriteExample {
    public static void main(String[] args) throws IOException {
        Properties properties=new Properties();
        properties.setProperty("loginName","Admin");
        properties.setProperty("loginPassword","Admin@1234");
        properties.setProperty("url","https://www.google.com");
        properties.setProperty("browser","google");
        properties.setProperty("env","stage");
        properties.setProperty("version","1.0");
        properties.store(new FileWriter("src/main/resources/myconfig.properties"),"properties file written");
        properties.clear();
    }
}
