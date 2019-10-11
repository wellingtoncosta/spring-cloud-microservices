package io.github.wellingtoncosta.sescomp.reservationservice.app.web.dto.mapper;

import io.github.wellingtoncosta.sescomp.reservationservice.app.web.dto.ReservationDto;
import io.github.wellingtoncosta.sescomp.reservationservice.domain.entity.Reservation;

public class ReservationDtoMapper {

    public static Reservation toDomain(ReservationDto dto) {
        Reservation entity = new Reservation();
        entity.setId(dto.getId());
        entity.setReservedAt(dto.getReservedAt());
        entity.setReturnedAt(dto.getReturnedAt());
        entity.setBook(BookDtoMapper.toDomain(dto.getBook()));
        entity.setCustomer(CustomerDtoMapper.toDomain(dto.getCustomer()));
        return entity;
    }

}
