package net.kiranatos.stepik.java_web_mail_ru.L6_3_XMLParser.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import net.kiranatos.stepik.java_web_mail_ru.L6_3_XMLParser.reflection.ReflectionHelper;

@SuppressWarnings("UnusedDeclaration")
public class SaxHandler extends DefaultHandler {
    private static final String CLASSNAME = "class";
    private String element = null;
    private Object object = null;

    public void startDocument() throws SAXException {
        System.out.println("Start document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End document ");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("uri = " +uri+ "; localName = "+localName+"; qName = "+qName+"; attributes = " + attributes.getLength());
        if (!qName.equals(CLASSNAME)) {
            element = qName;
        } else {
            String className = attributes.getValue(0);
            System.out.println("Class name: " + className);
            object = ReflectionHelper.createInstance(className);
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("uri = " +uri+ "; localName = "+localName+"; qName = "+qName);
        element = null;
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        if (element != null) {
            String value = new String(ch, start, length);
            System.out.println(element + " = " + value);
            ReflectionHelper.setFieldValue(object, element, value);
        }
    }

    public Object getObject() { return object; }
}
