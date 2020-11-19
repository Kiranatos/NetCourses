package net.kiranatos.epam.summer20.p1.myexperiment1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Test4 {
    String[] a;
    public static void main(@About String[] args) throws Exception {
        //new Test4().main(null);
        System.out.println(" MAIN ");
//        TestAnnotationAnalyzer analyzer = new TestAnnotationAnalyzer();
//        analyzer.parse(Test4.class);        

        Class cl = Class.forName("net.kiranatos.epam.summer20.p1.myexperiment1.Test4");
        if (!cl.isAnnotationPresent(About.class)){
            System.out.println("+");
        }
        Method[] method = cl.getMethods();
        Method methodMain = null;
        for(Method md: method){
            if ((md.getName()).equals("main")) { methodMain = md; System.out.println(" + ");}
            System.out.println(md.getName());
        }    
        System.out.println("\n\n");
        System.out.println(methodMain.getAnnotatedReturnType().toString());
        System.out.println(methodMain.getParameterCount());
        Parameter[] params = methodMain.getParameters();
        System.out.println("\n\n");
        for (Parameter p : params) {
            System.out.println(p.getName());
            System.out.println(p.getAnnotatedType().toString());
            System.out.println(p.getClass().toString());
            System.out.println(p.getType().toString());
            System.out.println(p.toString());
            
//            Class clazz = Class.forName(System.class.getName());
//                java.lang.reflect.Field mySecretField = System.class.getField("out");
//                java.io.PrintStream myOutSecret = (java.io.PrintStream)mySecretField.get(clazz);
//                myOutSecret.print(string);
//
//            
//            Class clazz = Class.forName(String[].class.getName());
//            String[] s = (String[])p.get.get(clazz);
            
            
        }
    
//    public static void showMe(String string) {
//            try {
//                Class clazz = Class.forName(Test4.class.getName());
//                Method method = Test4.class.getMethod("main", String.class);
//                java.io.PrintStream myOutSecret = (java.io.PrintStream)mySecretField.get(clazz);
//                myOutSecret.print(string);
//            } catch (Exception ex) {
//                java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//            }            
//        }

}
}
 
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@interface About{
    String info() default "what is this";
    Class<? extends Throwable> expected() default None.class;
    static class None extends Throwable {
        private static final long serialVersionUID = 1L;

        private None() {
        }
    }
}

//class TestAnnotationAnalyzer {
//    public void parse(Class<?> clazz) throws Exception {
//        Method[] methods = clazz.getMethods();
//        int pass = 0;
//        int fail = 0;
//        System.out.println(methods.length);
//
//        for (Method method : methods) {
//            System.out.println(method.getClass().getName());
//            
//            if (method.isAnnotationPresent(About.class)) {
//                // Получаем доступ к атрибутам
//                
//                About test = method.getAnnotation(About.class);
//                Class expected = test.expected();
//                try {
//                    method.invoke(null);
//                    pass++;
//                } catch (Exception e) {
//                    if (Exception.class != expected) {
//                        fail++;
//                    } else {
//                        pass++;
//                    }
//                }
//            }
//        }
//    }
//}