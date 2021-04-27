package am.itspace.mymapstructexample.endpoints;

import am.itspace.mymapstructexample.dto.UserGetDto;
import am.itspace.mymapstructexample.entity.User;
import am.itspace.mymapstructexample.mappers.MyMapperImpl;
import am.itspace.mymapstructexample.repositories.UserRepo;
import am.itspace.mymapstructexample.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepo userRepo;
    private final MyMapperImpl myMapper;
    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserGetDto>> getAllUsers(){

        List<UserGetDto> list = myMapper.usersToUserGetDto(userRepo.findAll());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> addUser (@RequestBody User user){
           return userService.addUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserGetDto> updateUser(@RequestBody User user, @PathVariable Integer id) {

            User existingUser = userRepo.getById(id).get();
            if (existingUser.getId() == id) {
                user.setId(id);
                userService.addUser(user);
                return new ResponseEntity<>(myMapper.userToUserGetDto(user), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
            userService.deleteUser(id);
            String message = "User was deleted successfully";
            return new ResponseEntity<>(message, HttpStatus.OK);

    }

}
