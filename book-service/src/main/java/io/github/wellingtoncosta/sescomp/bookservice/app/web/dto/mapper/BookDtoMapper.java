package io.github.wellingtoncosta.sescomp.bookservice.app.web.dto.mapper;

import io.github.wellingtoncosta.sescomp.bookservice.app.web.dto.BookDto;
import io.github.wellingtoncosta.sescomp.bookservice.domain.entity.Book;
import io.github.wellingtoncosta.sescomp.bookservice.domain.entity.BookStatus;

public class BookDtoMapper {

    public static Book toEntity(BookDto dto) {
        Book entity = new Book();
        entity.setId(dto.getId());
        entity.setAuthor(dto.getAuthor());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setStatus(BookStatus.values()[dto.getStatus()]);
        return entity;
    }

}
