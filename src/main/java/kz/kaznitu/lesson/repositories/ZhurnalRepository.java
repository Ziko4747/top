package kz.kaznitu.lesson.repositories;

import kz.kaznitu.lesson.models.Zhurnal;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ZhurnalRepository extends CrudRepository<Zhurnal, Long> {
    Optional<Zhurnal> findById(Long id);
}
