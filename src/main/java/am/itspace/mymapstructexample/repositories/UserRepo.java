package am.itspace.mymapstructexample.repositories;

import am.itspace.mymapstructexample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Override
    Optional<User> findById(Integer integer);

    Optional<User> findByEmail(String email);

    Optional<User> getById(int id);

    @Override
    void delete(User user);
}
