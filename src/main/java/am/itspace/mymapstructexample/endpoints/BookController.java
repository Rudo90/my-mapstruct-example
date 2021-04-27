package am.itspace.mymapstructexample.endpoints;

import am.itspace.mymapstructexample.dto.BookDto;
import am.itspace.mymapstructexample.entity.Book;
import am.itspace.mymapstructexample.repositories.BookRepo;
import am.itspace.mymapstructexample.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final BookRepo bookRepo;

    @GetMapping()
    public ResponseEntity<List<BookDto>> getBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(bookRepo.findAll()), HttpStatus.OK);
    }

    @PostMapping()
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable("id") int id){
       return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public void updateBook(@PathVariable("id") int id){
        bookService.addBook(bookRepo.getOne(id));
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable("id") int id){
        bookService.deleteBook(id);
    }

}
