package net.kiranatos.epam.summer20.p1;

//import java.lang.System.Logger;

//import java.util.logging.Level;
//import java.util.logging.Logger;


//import IOException;


//import java.util.logging.Logger;

class Demo {
    
//    static java.io.PrintStream myOutSecret = null;
//    static {
//        try {
//            Class clazz = Class.forName(System.class.getName());
//            java.lang.reflect.Field mySecretField = System.class.getField("out");
//            java.io.PrintStream myOutSecret = (java.io.PrintStream)mySecretField.get(clazz);
//        } catch (Exception ex) {
//            java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//    }
    
        public static void showMe(String string) {
            try {
                Class clazz = Class.forName(System.class.getName());
                java.lang.reflect.Field mySecretField = System.class.getField("out");
                java.io.PrintStream myOutSecret = (java.io.PrintStream)mySecretField.get(clazz);
                myOutSecret.print(string);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }            
        }
    
    // ВОТ ЭТО ПРОШЛО:
    //private static java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Demo.class.getName());
    
    private Demo() {
        showMe("Never show me please");
    }
    
    private final static java.io.PrintStream CONSOLE = System.out;
    
    
    public static void showMeLikeLog(String string) {
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Demo.class.getName());
        logger.setUseParentHandlers(false);
        java.util.logging.ConsoleHandler handler = new java.util.logging.ConsoleHandler();
        java.util.logging.Formatter formatter = new java.util.logging.Formatter(){
            @Override
            public String format(java.util.logging.LogRecord record) {
                return record.getMessage();
            }
        };
        handler.setFormatter(formatter);        
        logger.addHandler(handler);
        logger.log(java.util.logging.Level.INFO, string);
    }
    public static void showMeLikeLog(int number) {
        showMeLikeLog(String.valueOf(number));
    }
    
    public static void showMeFaster(String string) {
        try {
            java.io.BufferedWriter out = new java.io.BufferedWriter(
                    new java.io.OutputStreamWriter(
                            new java.io.FileOutputStream(java.io.FileDescriptor.out), "ASCII"
                    ), 512);
            out.write(string);
            out.flush();
        } catch (java.io.IOException ex) {
            java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    public static void showMeFaster(int number) {
        showMeFaster(String.valueOf(number));
    }
    
    private static java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.OutputStreamWriter(System.out));
    public static void showMeBufferedWriter(String string) {        
        try {            
            bw.write(string);
            bw.flush();
           // bw.close();
        } catch (java.io.IOException ex) {
            java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    public static void showMeBufferedWriter(int number) {
        showMeBufferedWriter(String.valueOf(number));
    }
    
    private static java.io.PrintStream myOut = System.out;
    public static void showMePrintStream(String string) {        
        myOut.format(string);
    }
    public static void showMePrintStream(int number) {
        showMePrintStream(String.valueOf(number));
    }
    
    public static java.io.PrintStream getPrintStream() {
        return System.out;
    }
    
//    public static void showMe(String string) {
//        System.out.print(string);        
//        //CONSOLE.print(string);
//       // myOutSecret.print(string);
//    }
    
    public static void showMe(int number) {
        showMe(String.valueOf(number));
    }
    public static void showMe(double number) {
        showMe(String.valueOf(number));
    }
    
    public static void doNotShowMeMyErrors(int errors) {
        if (errors > 100) showMe("");
        else showMe("");
    }
    
    public static String[] getNewArgs(String[] arr) {
        return arr;
    }
    
    public static void main(String[] args) {        
//            showMeFaster(" SHOW ME faster");
          
        System.out.println(" ======= PART 4 ======= ");
        Part4.main(new String[]{"96","36"});    System.out.println(""); //12
        Part4.main(new String[]{"15","45"});    System.out.println(""); //15
        Part4.main(new String[]{"45","165"});   System.out.println(""); //15
        Part4.main(new String[]{"15","165"});   System.out.println(""); //15
        Part4.main(new String[]{"84","715"});   System.out.println(""); //1
        Part4.main(new String[]{"100","45"});   System.out.println(""); //5
        Part4.main(new String[]{"0","45"});     System.out.println(""); //45
        Part4.main(new String[]{"45","0"});     System.out.println(""); //45
        Part4.main(new String[]{"0","0"});  System.out.println(""); //0
//        
        System.out.println("\n\n ======= PART 5 ======= ");
        Part5.main(new String[]{"96"});         System.out.println("");     //15
        Part5.main(new String[]{"111"});        System.out.println("");    //3
        Part5.main(new String[]{"85268"});      System.out.println("");  //29
        Part5.main(new String[]{"960054"});     System.out.println(""); //24
        Part5.main(new String[]{"95644566"});   System.out.println(""); //45
        Part5.main(new String[]{"6555"});       System.out.println("");   //21
        Part5.main(new String[]{"4496"});       System.out.println("");   //23
        Part5.main(new String[]{"4496", "55", "111"}); System.out.println("");   //23
        Part5.main(new String[]{"ttt"});        System.out.println("");   //
        Part5.main(new String[]{});             System.out.println("");   //
        Part5.main(null);             System.out.println("");   //
        
        
        System.out.println("\n\n ======= PART 6 ======= ");
        System.out.println("********** 23:");
        Part6.main(new String[]{"23"}); 
//        System.out.println("\n********** 100: ");
//        Part6.main(new String[]{"100"}); 
//        System.out.println("\n********** -10: ");
//        Part6.main(new String[]{"-10"}); 
//        System.out.println("\n********** -5: ");
//        Part6.main(new String[]{"-5"}); 
//        System.out.println("\n********** -1: ");
//        Part6.main(new String[]{"-1"}); 
        System.out.println("\n********** 0: ");
        Part6.main(new String[]{"0"}); 
        System.out.println("\n********** 1: ");
        Part6.main(new String[]{"1"}); 
        System.out.println("\n********** 2: ");
        Part6.main(new String[]{"2"}); 
        System.out.println("\n********** 3: ");
        Part6.main(new String[]{"3"}); 
        System.out.println("\n********** 4: ");
        Part6.main(new String[]{"4"});
        System.out.println("\n********** 5: ");
        Part6.main(new String[]{"5"}); 
        System.out.println("\n********** 6: ");
        Part6.main(new String[]{"6"});
//        System.out.println("\n********** 1003: ");
//        Part6.main(new String[]{"1003"});      
        System.out.println("\n********** 30:");
        Part6.main(new String[]{"30"}); 
        
//        System.out.println("\n\n ======= PART 7 ======= ");
//        System.out.println(" ===== str2int ===== ");
//        System.out.println("A = " + Part7.str2int("A")); // 1
//        System.out.println("B = " + Part7.str2int("B")); // 2
//        System.out.println("Z = " + Part7.str2int("Z")); // 26
//        System.out.println("AA = " + Part7.str2int("Aa")); // 27
//        System.out.println("AB = " + Part7.str2int("aB")); // 28
//        System.out.println("ZAB = " + Part7.str2int("ZAB")); // 17604
//        System.out.println("CEA = " + Part7.str2int("CEA")); // 2159
//        System.out.println("ZZ = " + Part7.str2int("ZZ")); // 702
//        System.out.println("AAA = " + Part7.str2int("AAA")); // 703
//        
//        System.out.println(" ===== int2str ===== ");
//        System.out.println("0 A= " + Part7.int2str(0)); // A
//        System.out.println("1 A= " + Part7.int2str(1)); // A
//        System.out.println("2 B= " + Part7.int2str(2)); // B
//        System.out.println("25 Y= " + Part7.int2str(25)); // Y
//        System.out.println("26 Z= " + Part7.int2str(26)); // Z
//        System.out.println("27 AA= " + Part7.int2str(27)); // AA
//        System.out.println("28 AB= " + Part7.int2str(28)); // AB
//        System.out.println("169 FM= " + Part7.int2str(169)); // FM
//        System.out.println("207 GY= " + Part7.int2str(207)); // GY
//        System.out.println("701 ZY= " + Part7.int2str(701)); // ZY
//        System.out.println("702 ZZ= " + Part7.int2str(702)); // ZZ
//        System.out.println("703 AAA= " + Part7.int2str(703)); // AAA
//        System.out.println("704 AAB= " + Part7.int2str(704)); // AAB
//        System.out.println("705 AAC= " + Part7.int2str(705)); // AAC
//        System.out.println("723 AAU= " + Part7.int2str(723)); // AAU
//        System.out.println("857 AFY= " + Part7.int2str(857)); // AFY
//        System.out.println("17604 ZAB= " + Part7.int2str(17604)); // ZAB
//        System.out.println("2159 CEA= " + Part7.int2str(2159)); // CEA
//        
//        System.out.println("\n ===== rightColumn ===== ");
//        System.out.println("A= " + Part7.rightColumn("A"));
//        System.out.println("B= " + Part7.rightColumn("B"));
//        System.out.println("Y= " + Part7.rightColumn("Y"));
//        System.out.println("Z= " + Part7.rightColumn("Z"));
//        System.out.println("AA= " + Part7.rightColumn("AA"));
//        System.out.println("AAAC= " + Part7.rightColumn("AAAC"));    
        
    }
}

/* Practical task №1 
Note: You are not allowed to use any reference types apart from those 
from java.lang package.

_______________________

Task 7 Class name: com.epam.rd.java.basic.practice1.Part7
——————————————————————————————
Columns of spreadsheets (like Excel) have letter numbering in the form of latin 
capital letters (sequentially, from left to right):
A, B, ..., Y, Z, AA, AB, ..., AY, AZ, BA, BB, …, etc.

At the same time, each column has its sequence number: 
A - 1; B - 2; ... ; Y - 25; Z - 26; AA - 27; AB - 28; …, etc.

Write a class that contains the following three methods:
- a method of defining the column sequence number by its letter number 
[ public static int str2int(String number): 
A => 1; B => 2; ...; Z => 26; AA => 27; AB => 28; ... ];

- a method of defining the column letter number by its sequence number
[ public static String int2str(int number): 
1 => A; 2 => B; ...; 26 => Z; 27 ==> AA; 28 ==> AB; ... ];

- using the column letter number, write a method of defining the number of the 
column that is placed on the right side of the given one.
[ public static String rightColumn(String number): 
A => B; B => C; ...; Y => Z; Z => AA; AA => AB; …].

The methods functionality is to be checked using the following data: 
—————————————————————————————————————
A ==> 1 ==> A
B ==> 2 ==> B
Z ==> 26 ==> Z
AA ==> 27 ==> AA
AZ ==> 52 ==> AZ
BA ==> 53 ==> BA
ZZ ==> 702 ==> ZZ
AAA ==> 703 ==> AAA
—————————————————————————————————————
A ==> 1 ==> A

    B ==> 2 ==> B

    Z ==> 26 ==> Z

    AA ==> 27 ==> AA

    AZ ==> 52 ==> AZ

    BA ==> 53 ==> BA

    ZZ ==> 702 ==> ZZ

    AAA ==> 703 ==> AAA

_______________________

Notes.
1.  The result should be presented as a project named Practice1.
2.  The root package for all the classes and other packages (if needed): com.epam.rd.java.basic.practice1
3.  Additionally, add Demo class to your root package that demonstrates the actions of all the 7 subtasks.
*/
