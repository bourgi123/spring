package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.entities.Etudiant;
import com.esprit.tic.twin.project_backend.entities.Reservation;
import com.esprit.tic.twin.project_backend.repositories.EtudiantRepository;
import com.esprit.tic.twin.project_backend.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class EtudiantServiceImp implements IEtudiantService{
    EtudiantRepository etudiantRepository;
    ReservationRepository reservationRepository;

    @Override
    public HashMap<String, Float> calculNouveauMontantInscriptionDesEtudiants() {
        return null;
    }

    @Override
    public Etudiant affecterEtudiantAReservation(String nomEt, String prenomEt, String idReservation) {
         Etudiant etudiant = etudiantRepository.findEtudiantByNomEtAndPrenomEt(nomEt,prenomEt);
        Reservation reservation = reservationRepository.findByIdReservation(idReservation);

        Set <Reservation> reservationsMisAJour = new HashSet<>();

        if(etudiant.getReservations()!=null)
        {
            reservationsMisAJour = etudiant.getReservations();
        }
        reservationsMisAJour.add(reservation);
        etudiant.setReservations(reservationsMisAJour);
        etudiantRepository.save(etudiant);
       return etudiant ;
    }
}
