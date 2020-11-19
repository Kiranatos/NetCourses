package net.kiranatos.javarush.сore.lvl7;

/* Java Core,  7 уровень, 10 лекция

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990

Old variant: package com.javarush.test.level17.lesson10.bonus01;
 */

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Core7Lvl17Lesson10Task11_CRUD {
    public static List<Person> allPeople = new ArrayList<Person>();
    
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        //start here - начни тут
        int index = args.length-1;
        int maxIndex = args.length-1;
        SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
        Date birthDate = new Date();
        boolean s = true;
        String nameCrUD = " ";

        String command = args[0];
        if (command.equals("-c")){
            birthDate = date_format.parse(args[maxIndex]);

            if (args[maxIndex-1].equals("м")) s = true;
            else s = false;

            nameCrUD=args[1];
            if (maxIndex>4) {
                for (int i=2; i<=maxIndex-2 ;i++) { nameCrUD=nameCrUD + " " + args[i]; }
            }
        } else if (command.equals("-u")){
            index = Integer.parseInt(args[1]);

            birthDate = date_format.parse(args[maxIndex]);

            if (args[maxIndex-1].equals("м")) s = true;
            else s = false;

            nameCrUD=args[2];
            if (maxIndex>5) {
                for (int i=1; i<maxIndex-2 ;i++) { nameCrUD=nameCrUD + args[i]; }
            }
        } else if (command.equals("-d")){index = Integer.parseInt(args[1]);}
        else if (command.equals("-i")){index = Integer.parseInt(args[1]);}

        
        if (command.equals("-c")) {
            if (s) allPeople.add(Person.createMale(nameCrUD, birthDate));
            else if (!s) allPeople.add(Person.createFemale(nameCrUD, birthDate));

            System.out.println(allPeople.size()-1);
        } else if (command.equals("-u")) {
            allPeople.get(index).setName(nameCrUD);
            allPeople.get(index).setBirthDay(birthDate);
            if (s) allPeople.get(index).setSex(Sex.MALE);
            else if (!s) allPeople.get(index).setSex(Sex.FEMALE);
        } else if (command.equals("-d")) {
            allPeople.get(index).setName(null);
            allPeople.get(index).setSex(null);
            allPeople.get(index).setBirthDay(null);
        } else if (command.equals("-i")) {
            String sex;
            String name = allPeople.get(index).getName();

            if (allPeople.get(index).getSex().equals(Sex.MALE)) sex = "м";
            else sex = "ж";

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String bdate = dateFormat.format(allPeople.get(index).getBirthDay());

            System.out.println(String.format("%s %s %s", name, sex, bdate));
        }        
    } // end of main method
    
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



