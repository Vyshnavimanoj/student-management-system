package studentcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studentcrud.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}