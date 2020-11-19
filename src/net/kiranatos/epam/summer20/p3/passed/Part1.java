package net.kiranatos.epam.summer20.p3.passed;

import java.util.regex.Matcher;

public class Part1 {
    
    private static final String UTF = "UTF-8";
    private static final String REGEX_LOGIN = "^[a-z\\u0430-\\u044F]+[^@]$";
    private static final String REGEX_NAME = "([A-Z\u0410-\u042F][a-z\u0430-\u044F]+\\s?){2}";
    private static final String REGEX_EMAIL = "[a-zA-Z\u0410-\u042F\u0430-\u044F][a-zA-Z\u0410-\u042F\u0430-\u044F\\d\\u002E\\u005F]+@([a-zA-Z]+\u002E){1,2}";
    private static final java.util.regex.Pattern PATTERN_LOGIN = java.util.regex.Pattern.compile(REGEX_LOGIN);
    private static final java.util.regex.Pattern PATTERN_NAME = java.util.regex.Pattern.compile(REGEX_NAME);
    private static final java.util.regex.Pattern PATTERN_EMAIL = java.util.regex.Pattern.compile(REGEX_EMAIL);
    private static final int TWO = 2;
    private static String[][] map = null;

    public static void main(String[] args) {
        String part1TXT = Util.getInput("part1.txt");
        Part1.convert1(part1TXT);
        Part1.convert2(part1TXT);        
        Part1.convert3(part1TXT);        
        Part1.convert4(part1TXT);
    }
    
    public static String convert1(String input) {  
        String[] outterArr = Demo.getStringInUTF(input, UTF).split(System.lineSeparator());
        StringBuilder sb = new StringBuilder();
        for (String oneStr : outterArr) {
            String[] innerArr = oneStr.split(";");
            String email = null;
            String login = null;
            for (String innStr : innerArr) {                
                if (null == email) {
                    email = getString(innStr, PATTERN_EMAIL);
                }
                if (null == login) {
                    login = getString(innStr, PATTERN_LOGIN);
                }
            }
            if ((null != login)&&(null != email)) {
                sb.append(login).append(": ").append(email).append(System.lineSeparator());
            }            
        }
        return sb.toString();
    }

    public static String convert2(String input) {
        String[] outterArr = Demo.getStringInUTF(input, UTF).split("\n");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < outterArr.length; i++) {
            String[] innerArr = outterArr[i].split(";");
            String mail = null;            
            for (String innStr : innerArr) {
                Matcher mName = PATTERN_NAME.matcher(innStr);
                while (mName.find()) {
                    String[] ns = mName.group().split("[\\s]");
                    if (ns.length == 2) sb.append(ns[1]).append(" ").append(ns[0]).append(" (email: ");                    
                }
                
                Matcher mMail = PATTERN_EMAIL.matcher(innStr);
                while (mMail.find()) {
                    mail = mMail.group();
                }            
            }
            if (null != mail) {
                    sb.append(mail).append(")\n");
            }
        }    
        return sb.toString();
    }

    public static String convert3(String input) {
        String[] outterArr = Demo.getStringInUTF(input, UTF).split("\n");
        map = new String[TWO][outterArr.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < outterArr.length; i++) { 
            String[] fio = getArrStringData(outterArr[i]);
              if (null != fio) {
                setInMatrix(fio[2].split("@")[1], fio[0]);
            }
        }
        
        for (int i = 0; i < map[0].length; i++) {
            if (null == map[0][i]) break;
            sb.append(map[0][i])
                    .append(" ==> ")
                    .append(map[1][i])
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String convert4(String input) {
        String[] outterArr = Demo.getStringInUTF(input, UTF).split(System.lineSeparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < outterArr.length; i++) {            
            String[] fio = getArrStringData(outterArr[i]);
            if (null != fio) {
                sb.append(fio[0])
                        .append(";")
                        .append(fio[1])
                        .append(";")
                        .append(fio[2])
                        .append(";")
                        .append(getRandom())                        
                        .append(System.lineSeparator());
            } else {
                sb.append(outterArr[i]).append(";").append("Password").append(System.lineSeparator());
            }
        }        
        return sb.toString().trim();
    }
    
    private static void setInMatrix(String domain, String login){
        if (null != map) {
            boolean cycle = true;
            int index = 0;
            while ((cycle)&&(index < map[0].length)) {            
                if (null != map[0][index]) {
                    if (map[0][index].equals(domain)){
                        cycle = forSonar(index, login);                                                                    
                    }                     
                } else {
                    map[0][index] = domain;
                    map[1][index] = login;
                    cycle = false;
                }
                index++;
            }
        }
    }
    
    private static boolean forSonar(int index, String login){
        if (null == map[1][index]) {
            map[1][index] = login;
        } else {
            map[1][index] = map[1][index] + ", " + login;
            return false;
        }        
        return true;
    }
    
    private static String[] getArrStringData(String line){
        String[] result = null;
        
        String[] innerArr = line.split(";");
        String email = null;
        String login = null;
        String name = null;
        for (String innStr : innerArr) {              
                if (null == email) {                    
                    email = getString(innStr, PATTERN_EMAIL);        
                }
                if (null == login) {
                    login = getString(innStr, PATTERN_LOGIN);
                }
                if (null == name) {
                    name = getString(innStr, PATTERN_NAME);
                }
        }
        
        if ((null != login)&&(null != email)&&(null != name)) {
            result = new String[3];
            result[0] = login;
            result[1] = name;
            result[2] = email;
        }        
        return result;
    }
    
    private static String getString(String line, java.util.regex.Pattern pattern){
        Matcher mName = pattern.matcher(line);
        if (mName.find()) {
            return mName.group().trim();
        }        
        return null;
    }
    
    private static String getRandom(){        
        String num = "000";
        while (num.length() != 4){
            num = String.valueOf(new java.security.SecureRandom().nextInt(10000));
        }
        
        return num;
    }
}