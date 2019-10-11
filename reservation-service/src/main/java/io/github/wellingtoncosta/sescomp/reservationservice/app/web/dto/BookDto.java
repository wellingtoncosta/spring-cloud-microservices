package io.github.wellingtoncosta.sescomp.reservationservice.app.web.dto;

import io.github.wellingtoncosta.sescomp.reservationservice.domain.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor public class BookDto {

    private long id;
    private String author;
    private String title;
    private String description;
    private int status;

    public BookDto(Book entity) {
        this.id = entity.getId();
        this.author = entity.getAuthor();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.status = entity.getStatus().ordinal();
    }

}
