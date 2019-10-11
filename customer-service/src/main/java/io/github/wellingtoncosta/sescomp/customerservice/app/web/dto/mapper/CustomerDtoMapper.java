package io.github.wellingtoncosta.sescomp.customerservice.app.web.dto.mapper;

import io.github.wellingtoncosta.sescomp.customerservice.app.web.dto.CustomerDto;
import io.github.wellingtoncosta.sescomp.customerservice.domain.entity.Customer;

public class CustomerDtoMapper {

    public static Customer toEntity(CustomerDto dto) {
        Customer entity = new Customer();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        return entity;
    }

}
