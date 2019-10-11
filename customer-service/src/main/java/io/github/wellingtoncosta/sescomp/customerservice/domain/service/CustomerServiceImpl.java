package io.github.wellingtoncosta.sescomp.customerservice.domain.service;

import io.github.wellingtoncosta.sescomp.customerservice.domain.entity.Customer;
import io.github.wellingtoncosta.sescomp.customerservice.domain.exception.CustomerNotFoundException;
import io.github.wellingtoncosta.sescomp.customerservice.resources.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Autowired public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override public Customer save(Customer customer) {
        return repository.save(customer);
    }

    @Override public Customer update(long id, Customer customer) {
        if(repository.existsById(id)) {
            customer.setId(id);
            return repository.save(customer);
        } else throw new CustomerNotFoundException(id);
    }

    @Override public void delete(long id) {
        repository.deleteById(id);
    }

    @Override public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override public Customer findById(long id) {
        Optional<Customer> optional = repository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else throw new CustomerNotFoundException(id);
    }

}
