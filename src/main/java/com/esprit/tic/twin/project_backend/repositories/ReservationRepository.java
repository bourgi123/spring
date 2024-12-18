package com.esprit.tic.twin.project_backend.repositories;

import com.esprit.tic.twin.project_backend.entities.Chambre;
import com.esprit.tic.twin.project_backend.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    Reservation findByIdReservation(String idresrvation);

    @Query("SELECT r FROM Reservation r WHERE r.anneeUniversitaire  BETWEEN :dateDebut  AND :dateFin ")
    List<Reservation> retrieveReservationParAnneeUniversitaire(@Param("dateDebut") Date dateDebut, @Param("dateFin") Date dateFin);

    @Query("SELECT count(r) FROM Reservation r " +
            "join Chambre c on r member  of c.reservationSet" +
            " WHERE r.estValide = true " +
            "AND EXTRACT(YEAR FROM r.anneeUniversitaire) = EXTRACT(YEAR FROM CURRENT_DATE) " +
            "AND c.numeroChambre = :num")
    Long countReservationDisponibleByAnneeEnCours(@Param("num") Long numChambre);
}
