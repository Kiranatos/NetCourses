package net.kiranatos.epam.summer20.p3.passed;

public class Part6 {
    
    private static final String REGEX_STRING = "[a-zA-Z\u0410-\u042F\u0430-\u044F]+";
    private static final java.util.regex.Pattern PATTERN = java.util.regex.Pattern.compile(REGEX_STRING);
    private static String[] words;
    private static int[] quantity;

    public static void main(String[] args) {
        String part6TXT = Util.getInput("part6.txt");        
        Part6.convert(part6TXT);
    }

    public static String convert(String input) {
        String decodedStr = Demo.getStringInUTF(input, "UTF-8");
        words = new String[decodedStr.split(" ").length];
        quantity = new int[words.length];
        countWords(decodedStr);
        return transformWords(decodedStr);
    }
    
    
    private static void countWords(String line){
        java.util.regex.Matcher mName = PATTERN.matcher(line);
        while (mName.find()) {
            inArray(words, mName.group());
        }
    }
    private static String transformWords(String line){
        java.util.regex.Matcher mName = PATTERN.matcher(line);
        StringBuffer sb = new StringBuffer();
        while (mName.find()) {
            if (checkQuantityMoreThanOne(mName.group())) {
                mName.appendReplacement(sb, "_" + mName.group());
            }            
        }
        mName.appendTail(sb);
        return sb.toString();
    }
    
    private static boolean inArray(String[] arr, String word){
        if ((0 < arr.length) && (null != word)) {
            for (int i = 0; i < arr.length; i++) {
                if (word.equals(arr[i])) {
                    quantity[i]++;
                    return true;
                } else if (null == arr[i]) {
                    arr[i] = word;
                    quantity[i]++;
                    return false;
                }
            }
        }
        return false;        
    }
    
    private static boolean checkQuantityMoreThanOne(String word){
        if ((word != null)&&(word.length() > 0)){
            for (int i = 0; i < words.length; i++) {
                if (null == words[i]) return false;                
                if ((word.equals(words[i])) && (quantity[i] > 1))
                    return true;
            }
        }        
        return false;
    }
}