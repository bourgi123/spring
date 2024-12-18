package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.entities.Etudiant;
import org.springframework.stereotype.Service;

import java.util.HashMap;


public interface IEtudiantService {

    HashMap<String,Float > calculNouveauMontantInscriptionDesEtudiants() ;
    Etudiant affecterEtudiantAReservation (String nomEt, String prenomEt, String idReservation) ;

}
