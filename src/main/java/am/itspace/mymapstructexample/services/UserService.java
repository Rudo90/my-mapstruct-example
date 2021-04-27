package am.itspace.mymapstructexample.services;

import am.itspace.mymapstructexample.entity.User;
import am.itspace.mymapstructexample.mappers.MyMapperImpl;
import am.itspace.mymapstructexample.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final MyMapperImpl myMapper;


    public ResponseEntity<String> addUser(User user){
        if(user != null && userRepo.findByEmail(user.getEmail()).isEmpty()){
            userRepo.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public void deleteUser(Integer id){

        if(id != null && userRepo.getById(id).isPresent()){
            User user = userRepo.getById(id).get();
            userRepo.delete(user);
        }

    }

}
