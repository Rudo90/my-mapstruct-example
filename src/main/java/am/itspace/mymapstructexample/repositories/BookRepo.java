package am.itspace.mymapstructexample.repositories;

import am.itspace.mymapstructexample.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {


}
