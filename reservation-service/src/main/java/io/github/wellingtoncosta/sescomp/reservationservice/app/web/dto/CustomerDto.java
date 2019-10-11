package io.github.wellingtoncosta.sescomp.reservationservice.app.web.dto;

import io.github.wellingtoncosta.sescomp.reservationservice.domain.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor public class CustomerDto {

    private long id;
    private String name;
    private String address;
    private String email;
    private String phone;

    public CustomerDto(Customer entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.address = entity.getAddress();
        this.email = entity.getEmail();
        this.phone = entity.getPhone();
    }

}
