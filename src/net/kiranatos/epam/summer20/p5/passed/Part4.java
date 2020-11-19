package net.kiranatos.epam.summer20.p5.passed;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part4 {
    private static final String FILE_NAME = "part4.txt";

    /**
     * If no file - it will be created with random matrix
     */
    private static void createFile(){
        int m = Demo.getRandom(30) + 1;
        int n = Demo.getRandom(200) + 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(Demo.getRandom(998)+1).append(' ');
            }
            sb.deleteCharAt(sb.length()-1).append(System.lineSeparator());
        }

        Demo.writeToFile(FILE_NAME, sb.toString().trim());
    }

    /**
     * Read information in file and return matrix int[][]. If some data in file incorrect, matrix's element will has
     * been assigned Integer.MIN_VALUE;
     * @param file
     * @return matrix will symmetric
     */
    private static int[][] readFile(File file) {
        char[] arr = new char[0];
        try (InputStream fileInputStream = new FileInputStream(file);
             Reader reader = new InputStreamReader(fileInputStream, Demo.CP1251);) {
            arr = new char[(int)file.length()];
            int pointer = reader.read();
            for (int i = 0; (pointer > 0) && (i < arr.length) ; i++) {
                arr[i] = (char)pointer;
                pointer = reader.read();
            }
        } catch (IOException ex) {
            Logger.getLogger(Part1.class.getName()).log(Level.SEVERE, null, ex);
        }

        String[] lines = new String(arr).split(System.lineSeparator());

        String[][] matrix = new String[lines.length][];
        int maxLengthOfElementsInLine = 0;
        for (int j = 0; j < matrix.length; j++) {
            matrix[j] = lines[j].split(" ");
            if (maxLengthOfElementsInLine < matrix[j].length) maxLengthOfElementsInLine = matrix[j].length;
        }

        int[][] matrixArr = getPrimordialMatrix(matrix.length, maxLengthOfElementsInLine);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                try {
                    matrixArr[i][j] = Integer.valueOf(matrix[i][j]);
                } catch (NumberFormatException e) {
                    matrixArr[i][j] = Integer.MIN_VALUE;
                }
            }
        }
        return matrixArr;
    }

    /**
     * @param height x elements
     * @param width y elements
     * @return matrix initiated with Integer.MIN_VALUE;
     */
    private static int[][] getPrimordialMatrix(int height, int width){
        int[][] matrixArr = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrixArr[i][j] = Integer.MIN_VALUE;
            }
        }

        return matrixArr;
    }

    /**
     * main method
     * @param args null
     */
    public static void main(final String[] args) {
        File file = new File(Demo.PATH_TO_FILE, FILE_NAME);
        if (!file.exists()) {
            createFile();
        }

        int[][] intArr = readFile(file);

        int max = Integer.MIN_VALUE;

        ExecutorService executor = Executors.newFixedThreadPool(intArr.length);
        List<Future<Integer>> list = new ArrayList<>();

        long timeMs = System.currentTimeMillis();
        for (int i = 0; i < intArr.length ; i++) {
            MyThread callThread = new MyThread();
            callThread.setMatrix(intArr[i]);

            Future<Integer> future = executor.submit(callThread);
            list.add(future);
        }

        for(Future<Integer> fut : list){
            try {
                int a = fut.get();
                if (a > max) max = a;
                Demo.sleepMilliseconds(1);
            } catch (InterruptedException | ExecutionException e) {
                Logger.getLogger(Part4.class.getName()).log(Level.SEVERE, null, e);
                Thread.currentThread().interrupt();
            }
        }
        timeMs = System.currentTimeMillis() - timeMs;
        System.out.println(max);
        System.out.println(timeMs);
        executor.shutdown();

        max = Integer.MIN_VALUE;
        timeMs = System.currentTimeMillis();
        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr[i].length ; j++) {
                if (max < intArr[i][j]) max = intArr[i][j];
                Demo.sleepMilliseconds(1);
            }
        }
        timeMs = System.currentTimeMillis() - timeMs;
        System.out.println(max);
        System.out.println(timeMs);
    }

    static class MyThread implements Callable<Integer> {
        int[] matrix;

        public void setMatrix(int[] matrix) {
            this.matrix = matrix;
        }

        @Override
        public Integer call() throws Exception {
            int max = Integer.MIN_VALUE;
            if ((matrix!=null)&&(matrix.length>0)){
                for (int b : matrix){
                    if (b > max) max = b;
                }
            }
            return max;
        }
    }
}