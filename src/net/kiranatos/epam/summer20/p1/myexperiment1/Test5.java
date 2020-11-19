package net.kiranatos.epam.summer20.p1.myexperiment1;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Test5 {
    
    static {
        RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
        List<String> arguments = runtimeMxBean.getInputArguments();
        for (String str : arguments) {
            System.out.println(str);            
        }
        
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace(); 
        for (StackTraceElement st : stackTrace) {
            System.out.println("=============");
            System.out.println(st.toString());
            System.out.println(st.getClassLoaderName());
            System.out.println(st.getMethodName());
        }
        System.out.println("****");
        System.out.println(System.getProperty("sun.java.command"));
        Map<String, String> mapP = System.getenv();
        for (String str: mapP.keySet()) 
            System.out.println(str + " = " + mapP.get(str));
        
        System.out.println("\n****\n");
        Properties ppp = System.getProperties();
        for (String str: ppp.stringPropertyNames()) 
            System.out.println(str + " = " + ppp.getProperty(str));

    }
    
    public static void main(String[] args) {    
        System.out.println("\n\n");
        for (int i = 0; i < args.length; i++) {
            System.out.println(" === " + args[i] + " === ");
        }
    }    
}
