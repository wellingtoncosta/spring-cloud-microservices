package io.github.wellingtoncosta.sescomp.reservationservice.app.web.controller;

import io.github.wellingtoncosta.sescomp.reservationservice.app.web.dto.ReservationDto;
import io.github.wellingtoncosta.sescomp.reservationservice.domain.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static io.github.wellingtoncosta.sescomp.reservationservice.app.web.dto.mapper.ReservationDtoMapper.toDomain;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService service;

    @Autowired
    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public List<ReservationDto> findAll() {
        return service.findAll().stream().map(ReservationDto::new).collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ReservationDto findById(@PathVariable("id") Long id) {
        return new ReservationDto(service.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ReservationDto save(@RequestBody ReservationDto dto) {
        return new ReservationDto(service.save(toDomain(dto)));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ReservationDto update(@PathVariable("id") Long id, @RequestBody ReservationDto dto) {
        return new ReservationDto(service.update(id, toDomain(dto)));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}
