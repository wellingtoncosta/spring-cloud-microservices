package io.github.wellingtoncosta.sescomp.reservationservice.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(long id) {
        super("Book with id = " + id + " was not found.");
    }

}
