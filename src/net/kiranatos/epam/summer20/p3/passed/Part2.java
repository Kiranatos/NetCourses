package net.kiranatos.epam.summer20.p3.passed;

public class Part2 {
    
    private static final String REGEX_STRING = "[a-zA-Z\u0410-\u042F\u0430-\u044F]+";
    private static final java.util.regex.Pattern PATTERN = java.util.regex.Pattern.compile(REGEX_STRING);
    private static int minLength = 0;
    private static int minQuantity = 0;
    private static int maxLength = 0;
    private static int maxQuantity = 0;

    public static void main(String[] args) {
        String part2TXT = Util.getInput("part2.txt");
        Part2.convert(part2TXT);
    }
    
    public static String convert(String input) {
        String decodedStr = Demo.getStringInUTF(input, "UTF-8");
        decodedStr = getString(decodedStr);        
        String[] arrStr = decodedStr.split("[*]");        
        calculationParametersForMax(arrStr);
        calculationParametersForMin(arrStr);
        
        StringBuilder sbMin = new StringBuilder("Min: ");
        StringBuilder sbMax = new StringBuilder("Max: ");
        String[] minWords = new String[minQuantity];
        String[] maxWords = new String[maxQuantity];
        for (String el : arrStr) {
            if (minLength == el.length()) {
                sonarShutUp(minWords, el, sbMin);
            } else if (maxLength == el.length()) {
                sonarShutUp(maxWords, el, sbMax);
            }            
        }
        
        if (5 < sbMin.length()) {
            sbMin.delete(sbMin.length()-2, sbMin.length());
        }
        
        if (5 < sbMax.length()) {
            sbMax.delete(sbMax.length()-2, sbMax.length());
        }
        return sbMin.append(System.lineSeparator()).append(sbMax).toString();
    }
    
    private static void sonarShutUp(String[] arr, String el, StringBuilder sb){
        if (!inArray(arr, el)) {
            sb.append(el).append(", ");
        }
    }

    private static boolean inArray(String[] arr, String word){
        if ((0 < arr.length) && (null != word)) {
            for (String w : arr) {
                if (word.equals(w)) return true;                
            }
            
            for (int i = 0; i < arr.length; i++) {
                if (null == arr[i]) {
                    arr[i] = word;
                    return false;
                }                
            }
        }
        return false;
    }
    
    private static String getString(String line){
        StringBuilder sb = new StringBuilder();
        java.util.regex.Matcher mName = PATTERN.matcher(line);
        while (mName.find()) {
            sb.append(mName.group()).append("*");            
        }
        
        if (0 < sb.length()) 
            sb.deleteCharAt(sb.length()-1);
        String result = sb.toString();
        
        if (0 < result.length()) 
            return result;
        else 
            return "When I was younger, so much younger than today";
    }
    
    private static void calculationParametersForMin(String[] arr){
        int minL;
        if (arr.length > 0) {
            minL = arr[0].length();
            for (String str : arr) {
                if (minL > str.length()) minL = str.length();
            }
            minLength = minL;
            for (String str : arr) {
                if (minL == str.length()) minQuantity++;
            }
        }        
    }
        
    private static void calculationParametersForMax(String[] arr){
        int maxL;
        if (0 < arr.length) {
            maxL = arr[0].length();
            for (String str : arr) {
                if (maxL < str.length()) maxL = str.length();
            }
            maxLength = maxL;
            for (String str : arr) {
                if (maxL == str.length()) maxQuantity++;
            }
        }        
    }
}
