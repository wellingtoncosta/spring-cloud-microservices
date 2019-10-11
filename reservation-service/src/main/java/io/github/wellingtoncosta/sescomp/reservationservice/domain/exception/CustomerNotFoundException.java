package io.github.wellingtoncosta.sescomp.reservationservice.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(long id) {
        super("Customer with id = " + id + " was not found.");
    }

}
