package net.kiranatos.epam.summer20.p1.myexperiment1;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;


public class Test2 {
    static List<String> arguments;
    static {
        RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
        arguments = runtimeMxBean.getInputArguments();
    }
    
    public static void main(String... args) {
        System.out.println("Mandragora");
        
        System.out.println("TEMP : "
      + System.getProperty("java.io.tmpdir"));
    System.out.println("PATH : "
      + System.getProperty("java.library.path"));
    System.out.println("CLASSPATH : "
      + System.getProperty("java.class.path"));
    System.out.println("SYSTEM DIR : " +
       System.getProperty("user.home")); // ex. c:\windows on Win9x
    System.out.println("CURRENT DIR: "
      + System.getProperty("user.dir"));
        
        
        
        for (String str : arguments) {
            System.out.println(str);
        }
    }    
}

