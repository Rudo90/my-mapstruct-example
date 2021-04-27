package am.itspace.mymapstructexample.endpoints;

import am.itspace.mymapstructexample.dto.AuthorAllDto;
import am.itspace.mymapstructexample.entity.Author;
import am.itspace.mymapstructexample.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping()
    public ResponseEntity<List<AuthorAllDto>> getAll(){
        return authorService.getAllAuthors();
    }

    @PostMapping()
    public void addAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
    }

    @PutMapping("/{id}")
    public void updateAuthor(@PathVariable("id") int id){
        authorService.addAuthor(authorService.getAuthor(id));
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable("id") int id){
        authorService.deleteAuthor(id);
    }






}
