package net.kiranatos.epam.summer20.p1.ex4;

/*
https://o7planning.org/ru/10197/java-annotations-tutorial
*/

import java.lang.reflect.Method;
 
public class HtmlGenerator {
 
    public static void main(String[] args) {
 
        Class<?> clazz = DocumentClass.class;
 
        // Проверить аннотирован (annotate) ли класс с помощью AnnHtmlUL или нет.
        boolean isHtmlUL = clazz.isAnnotationPresent(AnnHtmlUL.class);
 
        StringBuilder sb = new StringBuilder();
        if (isHtmlUL) { 
            // Получить объект AnnHtmlUL, аннотированный на данном классе.
            AnnHtmlUL annUL = clazz.getAnnotation(AnnHtmlUL.class);
 
            sb.append("<H3>" + clazz.getName() + "</H3>");
            sb.append("\n");
 
            // Получить значение элемента 'border' в AnnHtmlUL.
            String border = annUL.border();
 
            sb.append("<UL style='border:" + border + "'>");
 
            // Добавить новую строку.
            sb.append("\n");
 
            Method[] methods = clazz.getMethods();
 
            for (Method method : methods) {
                // Проверить аннотирован (annotate) ли данный метод с помощью AnnHtmlLI или нет?
                if (method.isAnnotationPresent(AnnHtmlLI.class)) {
                    // Получить ту аннотацию (annotation).
                    AnnHtmlLI annLI = method.getAnnotation(AnnHtmlLI.class);
 
                    // Получить значение элементов AnnHtmlLI.
                    String background = annLI.background();
                    String color = annLI.color();
 
                    sb.append("<LI style='margin:5px;padding:5px;background:" + background + ";color:" + color + "'>");
                    sb.append("\n");
                    sb.append(method.getName());
                    sb.append("\n");
                    sb.append("</LI>");
                    sb.append("\n");
                }
            }
            sb.append("</UL>");
        }
        writeToFile(clazz.getSimpleName() + ".html", sb);
    }
 
    // Записать информацию на экран Console (Или файл).
    private static void writeToFile(String fileName, StringBuilder sb) {
        System.out.println(sb);
    } 
}
