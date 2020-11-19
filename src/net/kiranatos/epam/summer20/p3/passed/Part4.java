package net.kiranatos.epam.summer20.p3.passed;

public class Part4 {

    public static void main(String[] args) {
        Part4.hash("Tanatos", "SHA-256");
        Part4.hash("Kratos5", "SHA-256");
    }

    public static String hash(String input, String algorithm) {
        byte[] hash = new byte[100];        
        try {
            java.security.MessageDigest digest = java.security.MessageDigest.getInstance(algorithm);
            digest.update(input.getBytes());         
            hash = digest.digest();
        } catch (java.security.NoSuchAlgorithmException ex) {
            java.util.logging.Logger.getLogger(Part4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }        
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            String code = Integer.toHexString(hash[i]);
            if (code.length() > 2) 
                code = code.substring(code.length()-2, code.length());
            else if (code.length() == 1) 
                code = "0" + code;
            sb.append(code.toUpperCase());            
        }
        return sb.toString();
    }
}
