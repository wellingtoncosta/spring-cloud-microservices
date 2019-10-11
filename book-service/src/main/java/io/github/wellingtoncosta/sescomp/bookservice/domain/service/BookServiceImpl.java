package io.github.wellingtoncosta.sescomp.bookservice.domain.service;

import io.github.wellingtoncosta.sescomp.bookservice.domain.entity.Book;
import io.github.wellingtoncosta.sescomp.bookservice.domain.exception.BookNotFoundException;
import io.github.wellingtoncosta.sescomp.bookservice.resources.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Autowired public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override public Book save(Book book) {
        return repository.save(book);
    }

    @Override public Book update(long id, Book book) {
        if(repository.existsById(id)) {
            book.setId(id);
            return repository.save(book);
        } else throw new BookNotFoundException(id);
    }

    @Override public void delete(long id) {
        repository.deleteById(id);
    }

    @Override public List<Book> findAll() {
        return repository.findAll();
    }

    @Override public Book findById(long id) {
        Optional<Book> optional = repository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else throw new BookNotFoundException(id);
    }

}
