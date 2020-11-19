package net.kiranatos.javarush.сore.lvl7;

/* Java Core,  7 уровень, 10 лекция
Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки,
которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Сигнатуру метода main не менять.  Метод joinData должен вызываться в main.

Old variant: package com.javarush.test.level17.lesson10.home09;
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Core7Lvl17Lesson10Task09 {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = reader.readLine();

            BufferedReader readerMatrix1 = new BufferedReader(new FileReader(file1));
            String lineOfFile = readerMatrix1.readLine();
            while (lineOfFile != null) {
                allLines.add(lineOfFile);
                System.out.println(lineOfFile);
                lineOfFile = readerMatrix1.readLine();
            }
            readerMatrix1.close();

            String file2 = reader.readLine();

            BufferedReader readerMatrix2 = new BufferedReader(new FileReader(file2));
            lineOfFile = readerMatrix2.readLine();
            while (lineOfFile != null) {
                forRemoveLines.add(lineOfFile);
                System.out.println(lineOfFile);
                lineOfFile=readerMatrix2.readLine();
            }
            readerMatrix2.close();

            new Core7Lvl17Lesson10Task09().joinData();
        }catch (IOException e){ }
    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines) ) {
            allLines.removeAll(forRemoveLines) ;
            return;
        }

        for (String s : forRemoveLines) {
            if (!allLines.contains(s)){
                allLines.clear();
                throw new CorruptedDataException();
            }
        }
    }
}

class CorruptedDataException extends IOException { }