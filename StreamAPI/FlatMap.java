package StreamAPI;

import entity.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
    public static void main(String[] args) {
//        Map->takes input and return single object
//        FlatMap->takes input and return group of objects(stream)

//        supppose we list<list<student>> and we want the get name of employees havaing age (25-50)
        System.out.println("name of employees having age (25-50)");

        List<Student> richStudents=Arrays.asList(
                new Student(19,"Raghav Mahajan",56,26900),
                new Student(13,"Madhav Mahajan",27,45678),
                new Student(12,"Ravi Mahajan",37,28455));

        List<Student> poorStudents=Arrays.asList(
                new Student(18,"kartik Mahajan",51,12900),
                new Student(16,"risha Mahajan",24,22678),
                new Student(14,"vanshika Mahajan",32,18455));

        List<List<Student>> students=Arrays.asList(richStudents,poorStudents);

        List<String> youngStudents=students.stream().flatMap(allStudents->allStudents.stream().filter(student -> student.getAge()>=25 && student.getAge()<=50).map(student -> student.getName())).toList();
        youngStudents.forEach(System.out::println);

        System.out.println("Convert this list of list of student into list of student");
        List<Student> allStudents=students.stream().flatMap(students1 ->students1.stream()).collect(Collectors.toList());
        allStudents.forEach(System.out::println);
    }
}
