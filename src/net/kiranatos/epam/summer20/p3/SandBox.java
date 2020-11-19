package net.kiranatos.epam.summer20.p3;

public class SandBox {
    public static void main(String[] args) {
        int x = 2;
        int y = 20;
        String[][] test = new String[x][y];
        System.out.println(test.length);
        System.out.println(test[0].length);
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[i].length; j++) {
                test[i][j] = "test[" + i + ";" + j + "]";
            }            
        }
        
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[i].length; j++) {
                System.out.print(test[i][j] + " ");
            }            
            System.out.println("\\u005F");
        }
        
    }    
}
