package kz.kaznitu.lesson.repositories;

import kz.kaznitu.lesson.models.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Optional<Student> findById(Long id);
}
