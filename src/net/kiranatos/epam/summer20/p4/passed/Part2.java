package net.kiranatos.epam.summer20.p4.passed;

public class Part2 {
    
    private static final String NAME_OF_INPUT_FILE = "part2.txt";
    private static final String NAME_OF_OUTPUT_FILE = "part2_sorted.txt";
    
    private static int getRandom(){        
        return 1 + new java.security.SecureRandom().nextInt(48);
    }
    
    private static void quickSort(int[] array, int low, int high) {
        if (array.length == 0) return; 
        if (low >= high) return; 
        
        int middle = low + (high - low) / 2;
        int opora = array[middle];
        
        int i = low;
        int j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }
 
            while (array[j] > opora) {
                j--;
            }
 
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        } 
        
        if (low < j)
            quickSort(array, low, j);
 
        if (high > i)
            quickSort(array, i, high);
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(getRandom()).append(" ");
        }        
        Demo.writeToFile(NAME_OF_INPUT_FILE, sb.deleteCharAt(sb.length()-1).toString());
        
        String numString = Demo.readFromFile(NAME_OF_INPUT_FILE).trim();
        System.out.printf("input ==> %s%n", numString);
        String[] numStrArr = numString.split(" ");
        int[] intArr = new int[numStrArr.length];
        for (int i = 0; i < numStrArr.length; i++) {
            intArr[i] = Integer.valueOf(numStrArr[i]);
        }
        quickSort(intArr, 0, intArr.length - 1);
        sb = new StringBuilder();
        for (int i = 0; i < intArr.length; i++) {
            sb.append(intArr[i]).append(" ");            
        }
        numString = sb.deleteCharAt(sb.length()-1).toString();
        
        Demo.writeToFile(NAME_OF_OUTPUT_FILE, numString);
        
        System.out.printf("output ==> %s%n", numString);
    }
    
    public static int uslessMethodForJUnitTestDivision(int a, int b) {
        return a/b;
    }
}