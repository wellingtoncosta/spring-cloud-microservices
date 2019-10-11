package io.github.wellingtoncosta.sescomp.reservationservice.resources.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservation")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_sequence")
    @SequenceGenerator(name = "reservation_sequence", sequenceName = "reservation_id_seq", allocationSize = 1)
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "reserved_at", nullable = false)
    private Date reservedAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "returned_at")
    private Date returnedAt;

    @Column(nullable = false)
    private long bookId;

    @Column(nullable = false)
    private long customerId;

}
