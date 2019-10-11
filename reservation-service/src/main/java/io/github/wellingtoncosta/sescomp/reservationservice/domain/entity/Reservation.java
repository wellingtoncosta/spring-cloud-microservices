package io.github.wellingtoncosta.sescomp.reservationservice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor public class Reservation {

    private long id;
    private Date reservedAt;
    private Date returnedAt;
    private Book book;
    private Customer customer;

}
