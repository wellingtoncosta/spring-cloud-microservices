package io.github.wellingtoncosta.sescomp.reservationservice.app.web.remote;

import feign.Headers;
import io.github.wellingtoncosta.sescomp.reservationservice.app.web.dto.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("book-service")
@Headers({"Content-type", "application/json"})
public interface BookApi {

    @GetMapping("/books/{bookId}")
    ResponseEntity<BookDto> findById(@PathVariable("bookId") Long bookId);

}
