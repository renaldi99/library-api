package com.enigma.libraryapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter@Getter@NoArgsConstructor@AllArgsConstructor
@Table(name = "trx_return_book")
public class ReturnBook {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "return_book_id")
    private String id;
    @ManyToOne
    @JoinColumn(name = "borrow_book_id")
    private BorrowBook borrowBook;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime returnDate;
    private Integer charge;
}
