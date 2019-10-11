package io.github.wellingtoncosta.sescomp.reservationservice.app.web.dto.mapper;

import io.github.wellingtoncosta.sescomp.reservationservice.app.web.dto.CustomerDto;
import io.github.wellingtoncosta.sescomp.reservationservice.domain.entity.Customer;

public class CustomerDtoMapper {

    public static Customer toDomain(CustomerDto dto) {
        Customer entity = new Customer();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        return entity;
    }

}
