package studentcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import studentcrud.model.Student;
import studentcrud.service.StudentService;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    // GET ALL
    @GetMapping("/students")
    public List<Student> getStudents() {

        return studentService.getStudents();
    }
    // GET STUDENT BY ID
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {

        return studentService.getStudentById(id);
    }

    // POST
    @PostMapping("/students")
    public String addStudent(@RequestBody Student student) {

        return studentService.addStudent(student);
    }

    // UPDATE
    @PutMapping("/students/{id}")
    public String updateStudent(@PathVariable int id,
                                @RequestBody Student updatedStudent) {

        return studentService.updateStudent(id, updatedStudent);
    }

    // DELETE
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {

        return studentService.deleteStudent(id);
    }
}