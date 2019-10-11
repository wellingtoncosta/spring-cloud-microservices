package io.github.wellingtoncosta.sescomp.reservationservice.app.web.remote;

import feign.Headers;
import io.github.wellingtoncosta.sescomp.reservationservice.app.web.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("customer-service")
@Headers({"Content-type", "application/json"})
public interface CustomerApi {

    @GetMapping("/customers/{customerId}")
    ResponseEntity<CustomerDto> findById(@PathVariable("customerId") Long customerId);

}
