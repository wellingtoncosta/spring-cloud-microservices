package io.github.wellingtoncosta.sescomp.customerservice.domain.service;

import io.github.wellingtoncosta.sescomp.customerservice.domain.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    Customer update(long id, Customer customer);

    void delete(long id);

    List<Customer> findAll();

    Customer findById(long id);

}
