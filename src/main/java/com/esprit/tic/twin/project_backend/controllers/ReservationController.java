package com.esprit.tic.twin.project_backend.controllers;

import com.esprit.tic.twin.project_backend.entities.Reservation;
import com.esprit.tic.twin.project_backend.services.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
@AllArgsConstructor
public class ReservationController {
    IReservationService reservationService;

    // au lieu de mettre le format de la date nestaaml el type localDate
    @GetMapping("/getReservationParAnneeUniversitaire/{dateDebut}/{dateFin}")
    public List<Reservation> getReservationParAnneeUniversitaire(@PathVariable("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd")Date dateDebut, @PathVariable("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
        return  reservationService.getReservationParAnneeUniversitaire(dateDebut,dateFin);
    }
}
