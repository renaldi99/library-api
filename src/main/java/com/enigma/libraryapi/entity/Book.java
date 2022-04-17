package com.enigma.libraryapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter@Getter@AllArgsConstructor@NoArgsConstructor
@Table(name = "mst_book")
public class Book {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "book_id")
    private String id;
    private String title;
    private String publisher;
    private String author;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date yearOfPublication;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer stock;
}
