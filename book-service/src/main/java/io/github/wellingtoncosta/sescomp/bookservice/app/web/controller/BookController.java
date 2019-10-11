package io.github.wellingtoncosta.sescomp.bookservice.app.web.controller;

import io.github.wellingtoncosta.sescomp.bookservice.app.web.dto.BookDto;
import io.github.wellingtoncosta.sescomp.bookservice.domain.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static io.github.wellingtoncosta.sescomp.bookservice.app.web.dto.mapper.BookDtoMapper.toEntity;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    @Autowired public BookController(BookService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public List<BookDto> findAll() {
        return service.findAll().stream().map(BookDto::new).collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public BookDto findById(@PathVariable("id") Long id) {
        return new BookDto(service.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public BookDto save(@RequestBody BookDto dto) {
        return new BookDto(service.save(toEntity(dto)));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public BookDto update(@PathVariable("id") Long id, @RequestBody BookDto dto) {
        return new BookDto(service.update(id, toEntity(dto)));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}
