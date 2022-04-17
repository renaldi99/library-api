package com.enigma.libraryapi.entity;

import com.enigma.libraryapi.utils.AddDayJodaTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trx_borrow_book")
public class BorrowBook {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "borrow_book_id")
    private String id;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime borrowedDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime returnDate;
    private String status;

    @PrePersist
    protected void onCreate() {
        this.borrowedDate = LocalDateTime.now();
        this.returnDate = LocalDateTime.now().plusDays(7);
    }
}
