package io.github.wellingtoncosta.sescomp.reservationservice.resources.repository;

import io.github.wellingtoncosta.sescomp.reservationservice.resources.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> { }
