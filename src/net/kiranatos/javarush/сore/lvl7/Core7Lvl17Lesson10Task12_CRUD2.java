package net.kiranatos.javarush.сore.lvl7;

/* Java Core,  7 уровень, 10 лекция
CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Old variant: package com.javarush.test.level17.lesson10.bonus02;
 */

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Core7Lvl17Lesson10Task12_CRUD2 {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        //start here - начни тут
        /*   view();
        String[] mC = {"-c","Игорь","м","15/04/1985","Марина","ж","25/12/1900","Коля","м","05/03/1999","Стеапaн","м","11/01/20130"};
        String[] matrixARGS = mC;
        String command = mC[0];
        */

        String[] matrixARGS = args;
        String command = args[0];

        if (command.equals("-c")){ creation(matrixARGS); }
        else if (command.equals("-u")){ updates(matrixARGS); }
        else if (command.equals("-d")){ deletion(matrixARGS); }
        else if (command.equals("-i")){ information(matrixARGS); }

       // view();
    } // end of main method

    private static void creation(String[] matrixARGS) throws ParseException {
        SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
        Date[] matrixDate = new Date[(matrixARGS.length-1)/3];
        boolean[] matrixSex = new boolean[(matrixARGS.length-1)/3];
        String[] matrixName = new String[(matrixARGS.length-1)/3];
        int bigMatrixIndex = 1;

        int k=0;
        while ((bigMatrixIndex+1)<matrixARGS.length) {
            matrixDate[k] = date_format.parse(matrixARGS[bigMatrixIndex+2]);

            if (matrixARGS[bigMatrixIndex+1].equals("м")) matrixSex[k] = true;
            else matrixSex[k] = false;

            matrixName[k] = matrixARGS[bigMatrixIndex];

            bigMatrixIndex = bigMatrixIndex+3;
            k++;
        }

        for (int j=0; j<matrixName.length; j++) {
            if (matrixSex[j]) allPeople.add(Person.createMale(matrixName[j], matrixDate[j]));
            else if (!matrixSex[j]) allPeople.add(Person.createFemale(matrixName[j], matrixDate[j]));

            System.out.println(allPeople.size() - 1);
        }

    }

    private static void updates(String[] matrixARGS) throws ParseException
    {
        SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
        Date[] matrixDate = new Date[(matrixARGS.length-1)/4];
        boolean[] matrixSex = new boolean[(matrixARGS.length-1)/4];
        String[] matrixName = new String[(matrixARGS.length-1)/4];
        int[] index = new int[(matrixARGS.length-1)/4];
        int bigMatrixIndex = 1;

        int k=0;
        while ((bigMatrixIndex+1)<matrixARGS.length) {

            index[k] = Integer.parseInt(matrixARGS[bigMatrixIndex]);

            matrixDate[k] = date_format.parse(matrixARGS[bigMatrixIndex+3]);

            if (matrixARGS[bigMatrixIndex+2].equals("м")) matrixSex[k] = true;
            else matrixSex[k] = false;

            matrixName[k] = matrixARGS[bigMatrixIndex+1];

            bigMatrixIndex = bigMatrixIndex+4;
            k++;
        }

        for (int j=0; j<index.length; j++) {

            allPeople.get(index[j]).setName(matrixName[j]);
            allPeople.get(index[j]).setBirthDay(matrixDate[j]);

            if (matrixSex[j]) allPeople.get(index[j]).setSex(Sex.MALE);
            else if (!matrixSex[j]) allPeople.get(index[j]).setSex(Sex.FEMALE);
        }
    }

    private static void deletion(String[] matrixARGS)
    {
        int[] index = new int[matrixARGS.length-1];
        int bigMatrixIndex = 1;

        int k=0;
        while ((bigMatrixIndex)<matrixARGS.length) {
            index[k] = Integer.parseInt(matrixARGS[bigMatrixIndex]);
            bigMatrixIndex++;
            k++;
        }

        for (int j=0; j<index.length; j++) {
            allPeople.get(index[j]).setName(null);
            allPeople.get(index[j]).setSex(null);
            allPeople.get(index[j]).setBirthDay(null);
        }
    }


    private static void information(String[] matrixARGS)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        int[] index = new int[matrixARGS.length-1];
        int bigMatrixIndex = 1;

        int k=0;
        while ((bigMatrixIndex)<matrixARGS.length) {
            index[k] = Integer.parseInt(matrixARGS[bigMatrixIndex]);
            bigMatrixIndex++;
            k++;
        }

        for (int j=0; j<index.length; j++) {
            String sex;
            String name = allPeople.get(index[j]).getName();

            if (allPeople.get(index[j]).getSex().equals(Sex.MALE)) sex = "м";
            else sex = "ж";

            String bdate = dateFormat.format(allPeople.get(index[j]).getBirthDay());

            System.out.println(String.format("%s %s %s", name, sex, bdate));
        }
    }

    private static void view () {
        //public static List<Person> allPeople = new ArrayList<Person>();
        //-c name1 sex1 bd1 name2 sex2 bd2 ...
        //-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...

        int v = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Iterator <Person> iterator = allPeople.iterator();
        while (iterator.hasNext()) {
            Person elem = iterator.next();
            String d = dateFormat.format(elem.getBirthDay());
            System.out.println(v +". " + elem.getName() + " " + elem.getSex() + " " + d);
            v++;
        }
    } 
    
    private enum Sex { MALE, FEMALE }

private static class Person {
    private String name;
    private Sex sex;
    private Date birthDay;

    private Person(String name, Sex sex, Date birthDay) {
        this.name = name;
        this.sex = sex;
        this.birthDay = birthDay;
    }

    public static Person createMale(String name, Date birthDay){
        return new Person(name, Sex.MALE, birthDay);
    }

    public static Person createFemale(String name, Date birthDay){
        return new Person(name, Sex.FEMALE, birthDay);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
} // end of class Core7Lvl17Lesson10Task11_CRUD

