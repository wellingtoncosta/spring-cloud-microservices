package io.github.wellingtoncosta.sescomp.reservationservice.resources.entity.mapper;

import io.github.wellingtoncosta.sescomp.reservationservice.domain.entity.Book;
import io.github.wellingtoncosta.sescomp.reservationservice.domain.entity.Customer;
import io.github.wellingtoncosta.sescomp.reservationservice.domain.entity.Reservation;
import io.github.wellingtoncosta.sescomp.reservationservice.resources.entity.ReservationEntity;

public class ReservationEntityMapper {

    public static Reservation toDomain(ReservationEntity entity) {
        Reservation reservation = new Reservation();
        reservation.setId(entity.getId());
        reservation.setReservedAt(entity.getReservedAt());
        reservation.setReturnedAt(entity.getReturnedAt());
        reservation.setBook(null);
        reservation.setCustomer(null);
        return reservation;
    }

    public static Reservation toDomain(ReservationEntity entity, Book book) {
        Reservation reservation = toDomain(entity);
        reservation.setBook(book);
        return reservation;
    }

    public static Reservation toDomain(ReservationEntity entity, Book book, Customer customer) {
        Reservation reservation = toDomain(entity, book);
        reservation.setCustomer(customer);
        return reservation;
    }

    public static ReservationEntity toEntity(Reservation reservation) {
        ReservationEntity entity = new ReservationEntity();
        entity.setId(reservation.getId());
        entity.setReservedAt(reservation.getReservedAt());
        entity.setReturnedAt(reservation.getReturnedAt());
        entity.setBookId(reservation.getBook() == null ? -1 : reservation.getBook().getId());
        entity.setCustomerId(reservation.getCustomer() == null ? -1 : reservation.getCustomer().getId());
        return entity;
    }

}
