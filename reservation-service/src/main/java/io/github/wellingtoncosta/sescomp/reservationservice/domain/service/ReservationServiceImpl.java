package io.github.wellingtoncosta.sescomp.reservationservice.domain.service;

import io.github.wellingtoncosta.sescomp.reservationservice.app.web.dto.BookDto;
import io.github.wellingtoncosta.sescomp.reservationservice.app.web.dto.CustomerDto;
import io.github.wellingtoncosta.sescomp.reservationservice.app.web.dto.mapper.BookDtoMapper;
import io.github.wellingtoncosta.sescomp.reservationservice.app.web.dto.mapper.CustomerDtoMapper;
import io.github.wellingtoncosta.sescomp.reservationservice.app.web.remote.BookApi;
import io.github.wellingtoncosta.sescomp.reservationservice.app.web.remote.CustomerApi;
import io.github.wellingtoncosta.sescomp.reservationservice.domain.entity.Book;
import io.github.wellingtoncosta.sescomp.reservationservice.domain.entity.Customer;
import io.github.wellingtoncosta.sescomp.reservationservice.domain.entity.Reservation;
import io.github.wellingtoncosta.sescomp.reservationservice.domain.exception.*;
import io.github.wellingtoncosta.sescomp.reservationservice.resources.entity.ReservationEntity;
import io.github.wellingtoncosta.sescomp.reservationservice.resources.entity.mapper.ReservationEntityMapper;
import io.github.wellingtoncosta.sescomp.reservationservice.resources.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service public class ReservationServiceImpl implements ReservationService {

    private final BookApi bookApi;
    private final CustomerApi customerApi;
    private final ReservationRepository repository;

    @Autowired public ReservationServiceImpl(
            BookApi bookApi,
            CustomerApi customerApi,
            ReservationRepository repository
    ) {
        this.bookApi = bookApi;
        this.customerApi = customerApi;
        this.repository = repository;
    }

    @Override public Reservation save(Reservation reservation) {
        checkBookAndCustomerArePresent(reservation);

        Book book = fetchBookOrThrow(reservation.getBook().getId());

        Customer customer = fetchCustomerOrThrow(reservation.getCustomer().getId());

        ReservationEntity entity = repository.save(ReservationEntityMapper.toEntity(reservation));

        return ReservationEntityMapper.toDomain(entity, book, customer);
    }

    private void checkBookAndCustomerArePresent(Reservation reservation) {
        if(reservation.getBook() == null) {
            throw new BadRequestException("Could not save reservation due book is not present");
        }

        if(reservation.getCustomer() == null) {
            throw new BadRequestException("Could not save reservation due customer is not present");
        }
    }

    private Book fetchBook(long id) {
        try {
            ResponseEntity<BookDto> bookResponse = bookApi.findById(id);
            if(bookResponse.getStatusCode().equals(HttpStatus.OK) && bookResponse.getBody() != null) {
                return BookDtoMapper.toDomain(bookResponse.getBody());
            } else return null;
        } catch (Exception e) {
            return null;
        }
    }

    private Book fetchBookOrThrow(long id) {
        try {
            ResponseEntity<BookDto> bookResponse = bookApi.findById(id);
            if(bookResponse.getStatusCode().equals(HttpStatus.OK) && bookResponse.getBody() != null) {
                return BookDtoMapper.toDomain(bookResponse.getBody());
            } else if(bookResponse.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                throw new BookNotFoundException(id);
            } else throw new BookServiceUnavailableException();
        } catch (Exception e) {
            return null;
        }
    }

    private Customer fetchCustomer(long id) {
        try {
            ResponseEntity<CustomerDto> customerResponse = customerApi.findById(id);
            if(customerResponse.getStatusCode().equals(HttpStatus.OK) && customerResponse.getBody() != null) {
                return CustomerDtoMapper.toDomain(customerResponse.getBody());
            } else return null;
        } catch (Exception e) {
            return null;
        }
    }

    private Customer fetchCustomerOrThrow(long id) {
        try {
            ResponseEntity<CustomerDto> customerResponse = customerApi.findById(id);
            if(customerResponse.getStatusCode().equals(HttpStatus.OK) && customerResponse.getBody() != null) {
                return CustomerDtoMapper.toDomain(customerResponse.getBody());
            } else if(customerResponse.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                throw new CustomerNotFoundException(id);
            } else throw new CustomerServiceUnavailableException();
        } catch (Exception e) {
            return null;
        }
    }

    @Override public Reservation update(long id, Reservation reservation) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override public void delete(long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override public List<Reservation> findAll() {
        return repository.findAll().stream().map(this::buildReservation).collect(Collectors.toList());
    }

    @Override public Reservation findById(long id) {
        Optional<ReservationEntity> optional = repository.findById(id);
        if(optional.isPresent()) {
            return buildReservation(optional.get());
        } else throw new ReservationNotFoundException(id);
    }

    private Reservation buildReservation(ReservationEntity entity) {
        return ReservationEntityMapper.toDomain(entity, fetchBook(entity.getBookId()), fetchCustomer(entity.getCustomerId()));
    }

}
