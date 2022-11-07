package kz.bitimbay.taskthree.springbootdemo.db;

import kz.bitimbay.taskthree.springbootdemo.models.Student;

import java.util.ArrayList;
import java.util.List;

public class DBManager {

    static List<Student> studentList = new ArrayList<>();

    public static String calculateMark(Student student){
        String mark = "";
        if(student.getExam() >= 90){
            mark = "A";
        } else if (student.getExam() >= 75 && student.getExam() <= 89) {
            mark = "B";
        } else if (student.getExam() >= 60 && student.getExam() <= 74) {
            mark = "C";
        } else if (student.getExam() >= 50 && student.getExam() <= 59) {
            mark = "D";
        } else if (student.getExam() < 50) {
            mark = "F";
        }
        return mark;
    }

    static {
        studentList.add(new Student(1L,"Sanzhar","Bitimbay", 95, "A"));
    }

    public static List<Student> getStudentList(){ return studentList;};


    static Long id = 2L;

    public static void addStudent(Student student) {
        student.setId(id);
        student.setName(student.getName());
        student.setSurname(student.getSurname());
        student.setExam(student.getExam());
        student.setMark(calculateMark(student));
        studentList.add(student);
        id++;
    }



}
