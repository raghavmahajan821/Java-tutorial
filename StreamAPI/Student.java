package entity;

import java.util.Objects;

public class Student implements Comparable<Student>{
    int studentId;
    String Name;
    int age;
    int salary;
    static String strategy;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        Name = name;
    }

    public Student(int studentId, String name, int age,int salary) {
        this(studentId,name);
        this.age = age;
        this.salary=salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getStudentId() {
        return studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return getStudentId() == student.getStudentId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId());
    }

    public static String getStrategy() {
        return strategy;
    }

    public static void setStrategy(String strategy) {
        Student.strategy = strategy;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", Name='" + Name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Student s1) {
        if(strategy.equalsIgnoreCase("name"))
            return s1.getName().compareToIgnoreCase(getName());
        else
            return getAge()-s1.getAge();
    }
}
