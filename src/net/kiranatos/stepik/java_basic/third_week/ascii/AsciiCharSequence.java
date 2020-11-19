package net.kiranatos.stepik.java_basic.third_week.ascii;

public class AsciiCharSequence implements CharSequence {
    
    private byte[] b;

    public AsciiCharSequence(byte[] ar) {
        b = new byte[ar.length];
    
        for (int i = 0; i<ar.length; i++) {
            b[i] = ar[i];
        }
    }
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (byte b1 : b) {
            sb.append( (char)b1 );
        }
        return sb.toString();
    }

    @Override
    public int length() {
        return b.length;
    }

    @Override
    public char charAt(int index) {
        return (char)b[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        
        byte[] br = new byte[end-start];
        int j = 0;
    
        for (int i = start; i<end; i++) {
            br[j] = b[i];
            j++;
        }
        
                
        return new AsciiCharSequence(br);
    }
    
}
