package am.itspace.mymapstructexample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    @JsonProperty("id")
    private int id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("release_date")
    private Date releaseDate;
    @JsonProperty("author_dto_set")
    private List<AuthorDto> authorDtoSet;

}