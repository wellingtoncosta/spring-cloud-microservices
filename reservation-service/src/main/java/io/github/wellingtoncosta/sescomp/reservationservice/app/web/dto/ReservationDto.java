package io.github.wellingtoncosta.sescomp.reservationservice.app.web.dto;

import io.github.wellingtoncosta.sescomp.reservationservice.domain.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor public class ReservationDto {

    private long id;
    private Date reservedAt;
    private Date returnedAt;
    private BookDto book;
    private CustomerDto customer;

    public ReservationDto(Reservation reservation) {
        this.id = reservation.getId();
        this.reservedAt = reservation.getReservedAt();
        this.returnedAt = reservation.getReturnedAt();
        this.book = reservation.getBook() == null ? null : new BookDto(reservation.getBook());
        this.customer = reservation.getCustomer() == null ? null : new CustomerDto(reservation.getCustomer());
    }

}
