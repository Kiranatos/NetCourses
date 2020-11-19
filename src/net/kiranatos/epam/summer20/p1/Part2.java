package net.kiranatos.epam.summer20.p1;

/* Task 2 Class name: com.epam.rd.java.basic.practice1.Part2
——————————————————————————————
Write a class that implements functionality of addition of numbers passed to 
the application as the command line parameters. */

public class Part2 {   
    public static void main(String[] args) {
        String[] myArgs = Demo.getNewArgs(args);
        
        int sum = 0;
        int count = 0;
        int errors = 0;
        
        if (0 == myArgs.length) { errors++; }
        
        for (String str: myArgs) {
            try {
                sum += Integer.valueOf(str);
                count++;
            } catch (NumberFormatException e){ 
               errors++;
            }
        }
        
        String result = (count>0) ? String.valueOf(sum) : "\n!!! Error 03 no elem !!!\n";
        
        Demo.showMe(result);
        Demo.doNotShowMeMyErrors(errors);
    }    
}
