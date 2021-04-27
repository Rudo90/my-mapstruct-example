package am.itspace.mymapstructexample.services;

import am.itspace.mymapstructexample.dto.AuthorAllDto;
import am.itspace.mymapstructexample.entity.Author;
import am.itspace.mymapstructexample.mappers.MyMapper;
import am.itspace.mymapstructexample.repositories.AuthorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepo authorRepo;
    private final MyMapper myMapper;

    public ResponseEntity<String> addAuthor(Author author){
        if(author != null && authorRepo.findByNameAndSurnameAndBirthday(author.getName(), author.getSurname(), author.getBirthday()).isEmpty()){
            authorRepo.save(author);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<AuthorAllDto>> getAllAuthors(){

        List<AuthorAllDto> authorDtoList = myMapper.authorsToAuthorAllDto(authorRepo.findAll());
        return new ResponseEntity<>(authorDtoList, HttpStatus.OK);

    }

    public Author getAuthor(Integer id){

        if (id != null && authorRepo.getById(id).isPresent()){
           return authorRepo.getOne(id);
        }
        return null;

    }

    public void deleteAuthor(Integer id){

        if(id != null && authorRepo.getById(id).isPresent()){
            Author author = authorRepo.getById(id).get();
            authorRepo.delete(author);
        }

    }



}
