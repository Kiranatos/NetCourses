package net.kiranatos.epam.summer20.p3.passed;

public class Part5 {

    private static char[] romanResultArray;
    private static int romanResultArrayIndex = 0;
    private static int reducedNumber;

    public static void main(String[] args) {
        for (int i = 1; i < 101; i++) {
            String roma = decimal2Roman(i);
            int deci = roman2Decimal(roma);
            System.out.printf("%d --> %s --> %d%n", i, roma, deci);            
        }
    }
    
    public static int roman2Decimal(String roman) {
        if (roman == null) return 0;
        roman = roman.toUpperCase();
        int index = 0;
        int result = 0;
        while (index < roman.length()){
            int temp1 = value(roman.charAt(index));
            if (index + 1 < roman.length() ){
                int temp2 = value(roman.charAt(index + 1));
                if (temp1 >= temp2) {
                    result += temp1;
                    index++;
                }
                else {
                    result = result + temp2 - temp1;
                    index +=2;                            
                }
            } else {
                result += temp1;
                index +=2;
            }            
        }
        
        return result; 
    }
    
    public static String decimal2Roman(int dec) {
        if (dec <= 0) { 
            return null; 
        }
        reducedNumber = dec;
        
        while(reducedNumber != 0) {            
            if (reducedNumber >= 1000) {
                repeatRomanLetter(1000, 1000, 'M');
            } else if (reducedNumber >= 500) { 
                sonarGetOffFromMe(900, 500, 500, 'D', 100, 'C', 'M');
            } else if (reducedNumber >= 100) { 
                sonarGetOffFromMe(400, 100, 100, 'C', 100, 'C', 'D');
            } else if (reducedNumber >= 50) {
                sonarGetOffFromMe(90, 50, 50, 'L', 10, 'X', 'C');
            } else if (reducedNumber >= 10) {
                sonarGetOffFromMe(40, 10, 10, 'X', 10, 'X', 'L');
            } else if (reducedNumber >= 5) { 
                sonarGetOffFromMe(9, 5, 5, 'V', reducedNumber, 'I', 'X');
            } else if (reducedNumber >= 1) { 
                sonarGetOffFromMe(4, 1, reducedNumber, 'I', reducedNumber, 'I', 'V');
            }
        }
        
        String result = getResultRoman();
        romanResultArray = null;
        romanResultArrayIndex = 0;
        reducedNumber = 0;
        return result;
    }    
    
    private static int value(char roman) { 
        switch (roman) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1;
        }
    }         
    
    private static void sonarGetOffFromMe(int a2, int a3, int a4, char c5, int a7, char c8, char c9) {
        if (reducedNumber < a2) { 
            repeatRomanLetter(a3, a4, c5);
        } else { 
            repeatRomanLetter(reducedNumber, a7, c8, c9);
        }
    }
    
    private static void add(char c) {
        if (romanResultArray == null) {
            romanResultArray = new char[romanResultArrayIndex+1];
        } else if (romanResultArray.length == romanResultArrayIndex){
            char[] temp = new char[romanResultArray.length+5];
            for (int i = 0; i < romanResultArray.length; i++) {
                temp[i] = romanResultArray[i];                
            }
            romanResultArray = temp;
        }
        romanResultArray[romanResultArrayIndex++] = c;        
    }
    
    public static String getResultRoman() {
        StringBuilder str = new StringBuilder();
        if ((romanResultArray != null) && (romanResultArray.length>0)) {
            for (int i = 0; i < romanResultArrayIndex; i++) {
                str.append(romanResultArray[i]);                
            }            
        }
        return str.toString();
    }
    
    private static void repeatRomanLetter(int n, int divisor, char... ch) { 
        for (int j = 0; j < reducedNumber/n; j++) {
            for (int i = 0; i < ch.length; i++) {
                add(ch[i]);
            }            
        }     
        reducedNumber = reducedNumber % divisor;
    }
}