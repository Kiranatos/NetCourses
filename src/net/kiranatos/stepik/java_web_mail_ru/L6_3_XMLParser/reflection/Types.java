package net.kiranatos.stepik.java_web_mail_ru.L6_3_XMLParser.reflection;

public enum Types {
    BYTE,
    BOOLEAN,
    SHORT,
    CHAR,
    INT,
    FLOAT,
    LONG,
    DOUBLE,
    STRING;

    public static Types getType(Class<?> clazz) {
        String className = clazz.getSimpleName().toUpperCase();
        return Types.valueOf(className);
    }
}
