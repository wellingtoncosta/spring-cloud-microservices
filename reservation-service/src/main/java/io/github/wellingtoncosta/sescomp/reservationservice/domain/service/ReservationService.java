package io.github.wellingtoncosta.sescomp.reservationservice.domain.service;

import io.github.wellingtoncosta.sescomp.reservationservice.domain.entity.Reservation;

import java.util.List;

public interface ReservationService {

    Reservation save(Reservation reservation);

    Reservation update(long id, Reservation reservation);

    void delete(long id);

    List<Reservation> findAll();

    Reservation findById(long id);

}
