package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.entities.Chambre;
import com.esprit.tic.twin.project_backend.entities.Reservation;
import com.esprit.tic.twin.project_backend.repositories.ChambreRepository;
import com.esprit.tic.twin.project_backend.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ReservationServiceImp implements IReservationService {
    ReservationRepository reservationRepository;
    ChambreRepository chambreRepository ;

    @Override
    public List<Reservation> getReservationParAnneeUniversitaire(Date dateDebut, Date dateFin) {
        return reservationRepository.retrieveReservationParAnneeUniversitaire(dateDebut,dateFin);
    }
@Scheduled(fixedRate = 300000)
    void nbPlacesDisponiblesParChambreAnneeEnCours(){
        List < Chambre> chambres =chambreRepository.findAll();
        for (Chambre chambre : chambres){
            Long nb = reservationRepository.countReservationDisponibleByAnneeEnCours(chambre.getNumeroChambre());
            log.info("nb place restantes en "+ LocalDate.now()+" pour la chambre "+chambre.getIdChmbre()+" est egale a " +nb);
        }

    }
}
