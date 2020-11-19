package net.kiranatos.epam.summer20.p1.myexperiment2;

/*
https://urvanov.ru/2018/05/05/%D0%B2%D0%B2%D0%B5%D0%B4%D0%B5%D0%BD%D0%B8%D0%B5-%D0%B2-jmx-%D0%B8-mbeans-%D0%B2-java/
*/

import java.lang.management.ManagementFactory;
 
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import net.kiranatos.OzoHelper;
 
public class App {
    public static void main( String[] args ) 
            throws MalformedObjectNameException, InstanceAlreadyExistsException, 
            MBeanRegistrationException, NotCompliantMBeanException, InterruptedException {
        
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer(); 
        ObjectName name = new ObjectName("net.kiranatos.epam.summer20.p1.myexperiment2:type=My"); 
        My mbean = new My(); 
        mbs.registerMBean(mbean, name); 
     
        System.out.println("Waiting forever..."); 
        long time = 0;
        while (time < 2_000) {            
            OzoHelper.sleepSeconds(2);
            System.out.println(time++);
           
        }
    }
}