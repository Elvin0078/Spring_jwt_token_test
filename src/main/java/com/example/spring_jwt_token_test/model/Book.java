package com.example.spring_jwt_token_test.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Book {

    private Long id;
    private String name;
    private String author;
    private String language;
    private int  noCopiesActual;
    private int  noCopiesCurrent;
    private BookCategory bookCategory;
    private int publicationyear;

}
