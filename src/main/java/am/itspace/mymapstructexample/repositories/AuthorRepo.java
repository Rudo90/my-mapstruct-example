package am.itspace.mymapstructexample.repositories;

import am.itspace.mymapstructexample.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface AuthorRepo extends JpaRepository<Author, Integer> {
    Optional<Author> getById(Integer id);
    Optional<Author> findByNameAndSurnameAndBirthday(String name, String surname, Date date);

}
