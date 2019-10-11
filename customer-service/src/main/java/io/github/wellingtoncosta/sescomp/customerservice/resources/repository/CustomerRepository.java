package io.github.wellingtoncosta.sescomp.customerservice.resources.repository;

import io.github.wellingtoncosta.sescomp.customerservice.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository public interface CustomerRepository extends JpaRepository<Customer, Long> { }
