package net.kiranatos.epam.summer20.p1;

public class Part7 {
    public static void main(String[] args) {
        System.out.println("A ==> 1 ==> A");
        System.out.println("B ==> 2 ==> B");
        System.out.println("Z ==> 26 ==> Z");
        System.out.println("AA ==> 27 ==> AA");
        System.out.println("AZ ==> 52 ==> AZ");
        System.out.println("BA ==> 53 ==> BA");
        System.out.println("ZZ ==> 702 ==> ZZ");
        System.out.println("AAA ==> 703 ==> AAA");
        //************************************************************************
        String arrow = " ==> ";
        System.out.println("A"+arrow+str2int("A")+arrow+int2str(1));
        System.out.println("B"+arrow+str2int("B")+arrow+int2str(2));
        System.out.println("Z"+arrow+str2int("Z")+arrow+int2str(26));
        System.out.println("AA"+arrow+str2int("AA")+arrow+int2str(27));
        System.out.println("AZ"+arrow+str2int("AZ")+arrow+int2str(52));
        System.out.println("BA"+arrow+str2int("BA")+arrow+int2str(53));
        System.out.println("ZZ"+arrow+str2int("ZZ")+arrow+int2str(702));
        System.out.println("AAA"+arrow+str2int("AAA")+arrow+int2str(703));
        //************************************************************************
        String formatStr = "%s ==> %d ==> %s%n";
        Demo.showMe(String.format(formatStr, "A", str2int("A"), int2str(1)));
        Demo.showMe(String.format(formatStr, "B", str2int("B"), int2str(2)));
        Demo.showMe(String.format(formatStr, "Z", str2int("Z"), int2str(26)));
        Demo.showMe(String.format(formatStr, "AA", str2int("AA"), int2str(27)));
        Demo.showMe(String.format(formatStr, "AZ", str2int("AZ"), int2str(52)));
        Demo.showMe(String.format(formatStr, "BA", str2int("BA"), int2str(53)));
        Demo.showMe(String.format(formatStr, "ZZ", str2int("ZZ"), int2str(702)));
        Demo.showMe(String.format(formatStr, "AAA", str2int("AAA"), int2str(703)));
        



    }
    
    public static int str2int(String number) {
        int result = 0; 
        for (int i = 0; i < number.length(); i++) { 
            result *= 26; 
            result += number.toUpperCase().charAt(i) - 'A' + 1;
        }
        return result; 
    }
    
    public static String int2str(int number) {
         int a = (number - 1) %26;
         String str = String.valueOf((char)(65 + a));
         int b = (number-1)/26;
         if (b > 0) return (int2str(b)) + str;
         else return str;
    }
    
    public static String rightColumn(String number) {        
        return int2str(str2int(number.toUpperCase())+1);
    }
}


/*
    private static final int BASE_OF_SCALE = 26;    
    private enum ScaleOfNotation {
        aa(0), A(1),B(2),C(3),D(4),E(5),F(6),G(7),H(8),I(9),J(10),K(11),L(12),M(13),
        N(14),O(15),P(16),Q(17),R(18),S(19),T(20),U(21),V(22),W(23),X(24),Y(25),
        Z(26); /* AA(27) AB(28) 
        A(1),B(2),C(3),D(4),E(5),F(6),G(7),H(8),I(9),J(10),K(11),L(12),M(13),
        N(14),O(15),P(16),Q(17),R(18),S(19),T(20),U(21),V(22),W(23),X(24),Y(25),
        Z(26); 
        A(0),B(1),C(2),D(3),E(4),F(5),G(6),H(7),I(8),J(9),K(10),L(11),M(12),
        N(13),O(14),P(15),Q(16),R(17),S(18),T(19),U(20),V(21),W(22),X(23),Y(24),
        Z(25);
        private final int index;
        private ScaleOfNotation(int index) { this.index = index; }
        public int getIndex() { return index;}
        public String getLetter() { return ScaleOfNotation.this.name();}
    }

    public static String int2strU(int number) { // 702
        int remainder = 0;

        
        String strCode = new String("");
        while ((number > BASE_OF_SCALE-1)) { // 702>25
            remainder = number % BASE_OF_SCALE; // 702%26 = 0
            System.out.printf("Remainder: %d : %d = %d \n", number, BASE_OF_SCALE, remainder);
            number /= BASE_OF_SCALE; // 702/26= 27           
            strCode = ScaleOfNotation.values()[remainder].getLetter() + strCode; // 0 = _A
        }
        
//        if (!(number == 0)) number -= 1;
        strCode = ScaleOfNotation.values()[number].getLetter() + strCode; // 1 = BA
        
        return strCode;
    }

public static int str2int(String number) {
        char last = number.charAt(number.length()-1);
        
        if (number.length() > 1) 
            return str2int(number.substring(0, number.length()-2));
        else 
            return ((int)number.charAt(0)) - 65;
    }    
    
    Z
    90-65=25 (mod)
    
    Y
    89-65=24 (mod)


https://www.geeksforgeeks.org/find-excel-column-number-column-title/
https://www.geeksforgeeks.org/find-excel-column-name-given-number/
https://stackoverflow.com/questions/3302857/algorithm-to-get-the-excel-like-column-name-of-a-number
https://math.semestr.ru/inf/index.php


*/
