package net.kiranatos.softserve;

import java.util.List;


public class CC {
    public int x= 1;
    public int y= 2;
    public CC func(CC obj) {
        CC coq3= new CC();
        coq3 = obj;
        coq3.x = obj.x++ + ++obj.y;
        obj.y = obj.y;
        return coq3;
    }
    
    
//    public static void main(String[] args) {
//        CC coq1 = new CC();
//        CC coq2 = coq1.func(coq1);
//        System.out.println(coq1.x + " " + coq1.y);
//        System.out.println(coq2.x + " " + coq2.y);
//    }
    
    
//    public static void main(String[] args) {
//boolean a = true;
//boolean b = true;
//boolean c = false;
//        System.out.println(!a||b&&!c);
//        
//        int s = 0;
//        int k = 0;
//        do {
//            s+=2;
//        } while (s!= 100);
//        System.out.println(s);
//        
//        for (int i = 0; i < 5; i++) {
//            for (int j = 5; j >=0; j--) {
//                System.out.print("*");
//                if (j==0) System.out.println("");
//            }
//            
//        }
//    
//        StringBuilder s1, s2;
//        String[] str;
//    String dds = null;
//        System.out.println(dds);
//        System.out.println(dds.toString());
//    
//    }
    
    public int number = 0;
    public void strat (){
        //List l
        try{
            number++;
            try{
            number++;
            try{
            number++;
            //throw new String("");
            }catch(Exception ex){
                number++;
            throw new Exception();
            }}catch(Exception ex){number++;
        }}catch(Exception ex){number++;    }}
    
    public static void main(String[] args) {
        CC d = new CC();
        d.strat();
        System.out.println(d.number);
    }

}
