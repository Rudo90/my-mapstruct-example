package am.itspace.mymapstructexample.services;

import am.itspace.mymapstructexample.dto.BookDto;
import am.itspace.mymapstructexample.entity.Author;
import am.itspace.mymapstructexample.entity.Book;
import am.itspace.mymapstructexample.mappers.MyMapperImpl;
import am.itspace.mymapstructexample.repositories.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepo;
    private final MyMapperImpl myMapper;

    public void addBook(Book book){
        if (book != null){
            bookRepo.save(book);
        }
    }

    public List<BookDto> getAllBooks(List<Book> books){
        return myMapper.booksToBookDto(books);
    }


    public BookDto getBookById(Integer id){

        if (id != null){
            return myMapper.bookToBookDto(bookRepo.getOne(id));
        }
        return null;
    }

    public void deleteBook(Integer id){

        if(id != null){
            bookRepo.delete(bookRepo.getOne(id));
        }
    }


}
