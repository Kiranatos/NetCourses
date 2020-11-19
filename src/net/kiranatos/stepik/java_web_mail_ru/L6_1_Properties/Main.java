package net.kiranatos.stepik.java_web_mail_ru.L6_1_Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("./src/stepik/java_web_mail_ru/L6_1_Properties/config.properties")) {
            properties.load(input);
            System.out.println(properties.getProperty("database"));
            System.out.println(properties.getProperty("dbuser"));
            System.out.println(properties.getProperty("dbpassword"));

        } catch (IOException ex) { ex.printStackTrace(); }
    }
}
