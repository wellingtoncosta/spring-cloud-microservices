package io.github.wellingtoncosta.sescomp.bookservice.domain.service;

import io.github.wellingtoncosta.sescomp.bookservice.domain.entity.Book;

import java.util.List;

public interface BookService {

    Book save(Book book);

    Book update(long id, Book book);

    void delete(long id);

    List<Book> findAll();

    Book findById(long id);

}
