package net.kiranatos.epam.summer20.p3.passed;

public class Part3 {

    private static final String REGEX_FIRST_LETTER = "(\\b[a-zA-Z\u0410-\u042F\u0430-\u044F](?=[a-zA-Z\u0410-\u042F\u0430-\u044F]{2,}\\b))";
    private static final java.util.regex.Pattern PATTERNL = java.util.regex.Pattern.compile(REGEX_FIRST_LETTER);

    public static void main(String[] args) { 
        String part3TXT = Util.getInput("part3.txt");        
        Part3.convert(part3TXT);
    }
   
    public static String convert(String input) {
        String decodedStr = Demo.getStringInUTF(input, "UTF-8");
        int[] arr = getCoord(decodedStr);
        char[] carr = decodedStr.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) break;
            carr[arr[i]] = invert(carr[arr[i]]);
        }
        return new String(carr);
    }
    
    private static int[] getCoord(String line){
        int[] arr = new int[line.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        java.util.regex.Matcher mName = PATTERNL.matcher(line);
        int index = 0;
        while (mName.find()) {
            arr[index] = mName.start();
            index++;
        }
        return arr;
    }    
    
    private static char invert(char letter){
        if ((letter >= 'a')&&(letter <= 'z')){
            return (char)(letter-32);
        } else if ((letter >= 'A')&&(letter <= 'Z')){
            return (char)(letter+32);
        } else if ((letter >= '\u0430')&&(letter <= '\u044F')){
            return (char)(letter-32);
        } else if ((letter >= '\u0410')&&(letter <= '\u042F')){
            return (char)(letter+32);            
        }
        return letter;
    }    
}