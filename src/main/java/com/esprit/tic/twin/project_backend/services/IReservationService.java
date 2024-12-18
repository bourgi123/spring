package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.entities.Reservation;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface IReservationService {
    public List<Reservation> getReservationParAnneeUniversitaire(Date dateDebut, Date dateFin ) ;

}
