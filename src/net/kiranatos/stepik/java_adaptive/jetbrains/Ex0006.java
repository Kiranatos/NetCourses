package net.kiranatos.stepik.java_adaptive.jetbrains;

import java.io.*;
import java.util.*;

/*
3.171 Usage of comparators and composition for sorting
Артем Бурылов, из курса Adaptive Java 

Let's assume there is class Student exists. Each student has
a name and a grade for exam in computer science.

You need to understand in what order the list will be sorted 
by the code below.

Note. The method getName() returns name of the student, 
getCsGrade() returns a grade for exam.

PS: see, the functional features in Java 8 allows us to 
write more concise code. 
In previous version the code would be less readable.

    Mary, 82
    Elizabet, 97
    Vladimir, 94
    Antonio, 85
    Alisa, 100
    John, 100
    Francis, 85
*/

public class Ex0006 {
    
    public static void main(String[] args) throws IOException {                
        
        List<Student> students = new ArrayList<>();
        
    /*    
        students.sort( 
                comparing( 
                        Student::getCsGrade, reverseOrder() 
                ).thenComparing(Student::getName)
        );        */
    }
    
}

class Student {
    String name;
    int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
    
    public String getName() {
        return name;
    }
    
    public int getCsGrade() {
        return grade;
    }
}