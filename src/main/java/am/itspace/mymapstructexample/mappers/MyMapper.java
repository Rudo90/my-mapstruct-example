package am.itspace.mymapstructexample.mappers;

import am.itspace.mymapstructexample.dto.*;
import am.itspace.mymapstructexample.entity.Author;
import am.itspace.mymapstructexample.entity.Book;
import am.itspace.mymapstructexample.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {User.class, Author.class, Book.class})
public interface MyMapper {

    BookSlimDto bookToBookSlimDto(Book book);

    @Mapping(source = "book.authorSet", target = "authorDtoSet")
    BookDto bookToBookDto(Book book);

    @Mapping(source = "author.birthday", target = "birthDate")
    AuthorDto authorToAuthorDto(Author author);

    @Mapping(source = "author.birthday", target = "birthDate")
    AuthorAllDto authorToAuthorAllDto(Author author);

    List<AuthorAllDto> authorsToAuthorAllDto(List<Author> authors);

    List<BookDto> booksToBookDto(List<Book> books);

    List<UserGetDto> usersToUserGetDto (List<User> users);

    UserGetDto userToUserGetDto(User user);

    @InheritInverseConfiguration(name = "userToUserGetDto")
    User userPostDtoToUser(UserPostDto userPostDto);
}