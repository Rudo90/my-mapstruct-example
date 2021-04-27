package am.itspace.mymapstructexample.dto;

import am.itspace.mymapstructexample.entity.Book;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorAllDto {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("birthDate")
    private Date birthDate;
    @JsonProperty("bookSet")
    private List<Book> bookSet;

}
