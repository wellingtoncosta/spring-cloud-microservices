package io.github.wellingtoncosta.sescomp.bookservice.resources.repository;

import io.github.wellingtoncosta.sescomp.bookservice.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository public interface BookRepository extends JpaRepository<Book, Long> { }
