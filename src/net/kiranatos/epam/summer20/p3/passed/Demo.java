package net.kiranatos.epam.summer20.p3.passed;

public class Demo {
    
    public static void main(String[] args) {        
        String part1TXT = Util.getInput("part1.txt");
        Part1.convert1(part1TXT);
        Part1.convert2(part1TXT);        
        Part1.convert3(part1TXT);        
        Part1.convert4(part1TXT);                
        
        String part2TXT = Util.getInput("part2.txt");
        Part2.convert(part2TXT);        
        Part2.convert(part1TXT);
                
        String part3TXT = Util.getInput("part3.txt");        
        Part3.convert(part3TXT);
        
        Part4.hash("asdf", "MD5");
        Part4.hash("asdf", "SHA-256");
        
        Part5.main(null);
        
        String part6TXT = Util.getInput("part6.txt");        
        Part6.convert(part6TXT);
    }
    
    static String getStringInUTF(String cryptoInput, String utf){
        String result;
        try {
            result = new String(cryptoInput.getBytes(), utf);
        } catch (java.io.UnsupportedEncodingException ex) {
            result = ex.getMessage();
        }
        return result;
    }
}