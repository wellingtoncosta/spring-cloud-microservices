package io.github.wellingtoncosta.sescomp.reservationservice.domain.entity;

import lombok.Data;

@Data public class Book {

    private long id;
    private String author;
    private String title;
    private String description;
    private BookStatus status;

}
