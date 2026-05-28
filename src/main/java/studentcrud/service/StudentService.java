package studentcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentcrud.model.Student;
import studentcrud.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    // GET ALL
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
    // GET STUDENT BY ID
    public Student getStudentById(int id) {

        return studentRepository.findById(id).orElse(null);
    }

    // ADD
    public String addStudent(Student student) {

        studentRepository.save(student);

        return "Student Saved Successfully";
    }

    // UPDATE
    public String updateStudent(int id, Student updatedStudent) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return "Student Not Found";
        }

        student.setName(updatedStudent.getName());

        studentRepository.save(student);

        return "Student Updated Successfully";
    }

    // DELETE
    public String deleteStudent(int id) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return "Student Not Found";
        }

        studentRepository.delete(student);

        return "Student Deleted Successfully";
    }
}