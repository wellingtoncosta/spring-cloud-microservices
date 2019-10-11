package io.github.wellingtoncosta.sescomp.bookservice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
    @SequenceGenerator(name = "book_sequence", sequenceName = "book_id_seq", allocationSize = 1)
    private long id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Enumerated
    @Column(nullable = false)
    private BookStatus status = BookStatus.AVAILABLE;

}
