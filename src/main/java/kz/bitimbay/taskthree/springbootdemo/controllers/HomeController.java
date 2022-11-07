package kz.bitimbay.taskthree.springbootdemo.controllers;

import kz.bitimbay.taskthree.springbootdemo.db.DBManager;
import kz.bitimbay.taskthree.springbootdemo.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    String getHomePage(Model model){
        List<Student> allStudents = DBManager.getStudentList();
        model.addAttribute("studentList", allStudents);
        return "homepage";
    }

    @GetMapping(value = "/addstudent")
    String addStudentForm(Model model){
        return "addstudent";
    }

    @PostMapping(value = "/addstudent")
    String addStudent(Model model,
                      @RequestParam(name = "studentName") String name,
                      @RequestParam(name = "studentSurname") String surname,
                      @RequestParam(name = "studentExam") int exam
                      ){
        Student newStud = new Student();
        newStud.setName(name);
        newStud.setSurname(surname);
        newStud.setExam(exam);
        DBManager.addStudent(newStud);
        return "redirect:/";
    }

}
