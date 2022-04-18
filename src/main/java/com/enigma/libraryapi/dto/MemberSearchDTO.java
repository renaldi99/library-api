package com.enigma.libraryapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter@Getter@AllArgsConstructor@NoArgsConstructor
public class MemberSearchDTO {
    private String searchByFirstName;
    private String searchByLastName;
    private Date searchByDateOfBirth;
    private String searchByStatus;
}
