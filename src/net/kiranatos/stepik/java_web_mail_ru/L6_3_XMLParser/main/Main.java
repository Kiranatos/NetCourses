package net.kiranatos.stepik.java_web_mail_ru.L6_3_XMLParser.main;

import net.kiranatos.stepik.java_web_mail_ru.L6_3_XMLParser.resources.DBParametersResource;
import net.kiranatos.stepik.java_web_mail_ru.L6_3_XMLParser.sax.ReadXMLFileSAX;

public class Main {
    
    private static final String PATH = "./src/stepik/java_web_mail_ru/L6_3_XMLParser/data/MySqlResource.xdb";
    
    public static void main(String[] args) throws Exception {
        DBParametersResource resource = (DBParametersResource) ReadXMLFileSAX.readXML(PATH);
        System.out.println(resource);
    }
}
