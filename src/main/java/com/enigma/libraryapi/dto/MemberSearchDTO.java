package com.enigma.libraryapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@AllArgsConstructor@NoArgsConstructor
public class MemberSearchDTO {
    private String searchByFirstName;
    private String searchByLastName;
    private String searchByDateOfBirth;
    private String searchByStatus;
}
