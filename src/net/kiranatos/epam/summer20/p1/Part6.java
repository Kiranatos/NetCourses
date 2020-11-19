package net.kiranatos.epam.summer20.p1;

/* Task 6 Class name: com.epam.rd.java.basic.practice1.Part6
——————————————————————————————
Write a class that creates an array from n elements and fills it with an 
ascending sequence of prime numbers (2, 3, 5, 7 …). The n number should be 
passed as the command line parameter. */

public class Part6 {
//    public static void main(String[] args) {
//        if (0 >= args.length) System.out.println("!!! Error 01 no elem !!!");
//        int value = 0;
//        try {
//            value = Math.abs(Integer.valueOf(args[0]));
//        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e){ 
//            System.out.println("!!! Error 02 no elem !!!" + args[0]); 
//        }
//        
//        boolean space = false;
//        for (int i = 0; i <= value; i++) {
//            if (checkSimple(i)) {
//                if (space) System.out.print(" ");
//                System.out.print(i);
//                if (!space) space = true;
//            }
//        }
//    }
    
    private static boolean checkSimple(int i) {
        if (i<=1) return false;
        else if (i <=3) return true;
        else if (i%2==0 || i %3 ==0) return false;
        int n = 5;
        while (n*n <= i){
            if (i % n ==0 || i % (n+2) == 0)
                return false;
            n=n+6;
        }
        return true;
    }
    
//    public static void main(String[] args) {
//        if ((args != null) && (args.length!=0)) {
//            int value = 0;
//            try {
//                value = Math.abs(Integer.valueOf(args[0]));
//            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e){ 
//                System.out.println("!!! Error 02 no elem !!!" + args[0]); 
//            }
//            int[] simple = new int[value];
//            
//            int index = 2;
//            for (int i = 0; i < simple.length; i++) {
//                while (true) {
//                    if (checkSimple(index)) { 
//                        simple[i] = index++;
//                        break;
//                    }
//                    index++;
//                }
//            }
//            
//            boolean space = false;
//            for (int i = 0; i < simple.length; i++) {
//                if (space) System.out.print(" ");
//                System.out.print(simple[i]);
//                if (!space) space = true;
//            }
//        }
//    }
    
    public static void main(String[] args) {
        int errors = 0;
        if ((args != null) && (args.length!=0)) {
            int value = 0;
            try {
                value = Math.abs(Integer.valueOf(args[0]));
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e){ errors++; }            
            
            showArray(createArray(value));            
        }
        Demo.doNotShowMeMyErrors(errors);
    }
    
    private static void showArray(int[] simple) {
        boolean space = false;
        for (int i = 0; i < simple.length; i++) {
            if (space) Demo.showMe(" ");
            Demo.showMe(simple[i]);
            if (!space) space = true;
        }        
    }
    
    private static int[] createArray(int value) {
        int[] simple = new int[value];
        int index = 2;
        for (int i = 0; i < simple.length; i++) {
            while (true) {
                if (checkSimple(index)) { 
                    simple[i] = index++;
                    break;
                }
                index++;
            }
        }
        return simple;
    }

}
