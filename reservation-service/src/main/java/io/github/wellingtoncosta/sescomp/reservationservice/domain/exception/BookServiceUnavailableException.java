package io.github.wellingtoncosta.sescomp.reservationservice.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class BookServiceUnavailableException extends RuntimeException {

    public BookServiceUnavailableException() {
        super("Book service is unavailable.");
    }

}
