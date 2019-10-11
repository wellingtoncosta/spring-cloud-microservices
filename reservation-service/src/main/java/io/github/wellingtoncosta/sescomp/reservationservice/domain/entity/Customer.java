package io.github.wellingtoncosta.sescomp.reservationservice.domain.entity;

import lombok.Data;

@Data public class Customer {

    private long id;
    private String name;
    private String address;
    private String email;
    private String phone;

}
