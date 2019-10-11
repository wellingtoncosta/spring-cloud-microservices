package io.github.wellingtoncosta.sescomp.customerservice.app.web.controller;

import io.github.wellingtoncosta.sescomp.customerservice.app.web.dto.CustomerDto;
import io.github.wellingtoncosta.sescomp.customerservice.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static io.github.wellingtoncosta.sescomp.customerservice.app.web.dto.mapper.CustomerDtoMapper.toEntity;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    @Autowired public CustomerController(CustomerService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public List<CustomerDto> findAll() {
        return service.findAll().stream().map(CustomerDto::new).collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public CustomerDto findById(@PathVariable("id") Long id) {
        return new CustomerDto(service.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public CustomerDto save(@RequestBody CustomerDto dto) {
        return new CustomerDto(service.save(toEntity(dto)));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public CustomerDto update(@PathVariable("id") Long id, @RequestBody CustomerDto dto) {
        return new CustomerDto(service.update(id, toEntity(dto)));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}
