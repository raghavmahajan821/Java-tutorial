package StreamAPI;

import entity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main1 {
    public static void main(String[] args) {
        List<String> vehicles= Arrays.asList("Bus","Car","Bicycle","Train","Flight");
//        Convert elements into uppercase
        System.out.println("Convert elements into uppercase using enhanced for loop ");
//       Before java 8
        List<String> F_VEHICLES=new ArrayList<>();
        for(String str:vehicles){
            F_VEHICLES.add(str.toUpperCase());
        }

        for(String str:F_VEHICLES){
            System.out.println(str);
        }

        /*using stream*/
        System.out.println("Convert elements into uppercase using stream ");
        List<String> VEHICLES=vehicles.stream().map(str->str.toUpperCase()).toList();
//        or
//        List<String> VEHICLES=vehicles.stream().map(str->str.toUpperCase()).collect(Collectors.toList());
        VEHICLES.forEach(System.out::println);

//        print elements whose length lies between 4 and 6 and then print their length
        System.out.println("print elements whose length lies between 4 and 6 and then print their length");
        vehicles.stream().filter(str->str.length()>=4 && str.length()<=6).map(str->str.length()).forEach(System.out::println);
//        or
        vehicles.stream().filter(str->str.length()>=4 && str.length()<=6).forEach(str->System.out.println(str+" "+str.length()));

//        filter list of students having greater than 25k
        System.out.println("filter list of students having greater than 25k ");
        List<Student> students=Arrays.asList(
                new Student(19,"Raghav Mahajan",56,26900),
                new Student(13,"Madhav Mahajan",27,45678),
                new Student(12,"Ravi Mahajan",37,23455));

        List<Student> richStudents=students.stream().filter(student->student.getSalary()>25000).collect(Collectors.toList());
        richStudents.forEach(System.out::println);

//        create list of salaries having value greater than 25k
        System.out.println("create list of salaries having value greater than 25k");
        List<Integer> salaries=students.stream().filter(student -> student.getSalary()>25000).map(student -> student.getSalary()).collect(Collectors.toList());
        salaries.forEach(System.out::println);
    }
}
