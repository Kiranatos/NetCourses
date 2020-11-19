package net.kiranatos.stepik.java_adaptive.functional;

import java.util.ArrayList;
import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
//import static java.util.Collections.reverseOrder;
//import static java.util.Collections.reverseOrder;
//import static java.util.Comparator.reverseOrder;
import java.util.List;

/* 2.13 Usage of comparators and composition for sorting
Artyom Burylov, из курса Java. Functional programming — 2 Practical lessons "Java. Functional programming"

Let's assume there is class Student exists. Each student has a name and a 
grade for exam in computer science.
You need to understand in what order the list will be sorted by the code below.

List<Student> students = ...
students.sort(
        comparing(Student::getCsGrade, reverseOrder())
                .thenComparing(Student::getName));

Note. The method getName() returns name of the student, getCsGrade() returns 
a grade for exam.
PS: see, the functional features in Java 8 allows us to write more concise code.
In previous version the code would be less readable. 
    Mary, 82
    Elizabet, 97
    Vladimir, 94
    Alisa, 100
    John, 100
    Francis, 85
    Antonio, 85
*/

public class Func03_ex_2_13 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Mary", 82));
        students.add(new Student("Elizabet", 97));
        students.add(new Student("Vladimir", 94));
        students.add(new Student("Alisa", 100));
        students.add(new Student("John", 100));
        students.add(new Student("Francis", 85));
        students.add(new Student("Antonio", 85));
        students.sort(
                comparing(Student::getCsGrade, reverseOrder())
                        .thenComparing(Student::getName));
                
        students.forEach(System.out::println);
        
        
        
    }
}

class Student{
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
    public String getName() { return this.name; }
    public int getCsGrade() { return this.grade; }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", grade=" + grade + '}';
    }
}
