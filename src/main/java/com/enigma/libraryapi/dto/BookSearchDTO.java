package com.enigma.libraryapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor@NoArgsConstructor
@Setter@Getter
public class BookSearchDTO {
    private String searchByTitle;
    private String searchByAuthor;
    private String searchByPublisher;
    @JsonFormat(pattern = "yyyy")
    private Date searchByYear;
}
