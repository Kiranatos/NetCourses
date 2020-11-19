package net.kiranatos.epam.summer20.p1;

/* Task 5 Class name: com.epam.rd.java.basic.practice1.Part5
——————————————————————————————
Write a class that implements functionality of defining the sum of the digits of 
a whole positive number passed to the application as the command line parameter. */

public class Part5 {    
    
    public static void main(String[] args) {        
        int number = 0;
        int sum = 0;        
        
        if ((args != null) && (0 < args.length) && (java.util.regex.Pattern.matches("[0-9]+", args[0]))) {
            try {
                number = Integer.valueOf(args[0]);                
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e){ 
                java.util.logging.Logger.getLogger(Part5.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
            }
        }
        
        while (number > 0) {
            sum += number%10;
            number /= 10;
        }
        
        Demo.showMe(sum);        
    }
    
//    public static void main(String[] args) {
//        int errors = 0;
//        if (0 >= args.length) { errors++; }
//        int number = 0;
//        int sum = 0;
//        try {
//            number = Integer.valueOf(args[0]);                
//        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e){ 
//            errors++;
//        }
//        
//        while (number > 0) {
//            sum += number%10;
//            number /= 10;
//        }
//        
//        Demo.showMe(sum);
//        Demo.doNotShowMeMyErrors(errors);
//    }

}
