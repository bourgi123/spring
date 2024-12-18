package com.esprit.tic.twin.project_backend.controllers;

import com.esprit.tic.twin.project_backend.entities.Etudiant;
import com.esprit.tic.twin.project_backend.services.IEtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("etudiant")
public class EtudiantController {
    IEtudiantService etudiantService;

    @PutMapping("/affecterEtudiantAReservation/{nom}/{prenom}/{idres}")
    public Etudiant affecterEtudiantAReservation(@PathVariable ("nom") String nomEt,@PathVariable ("prenom") String prenomEt,@PathVariable ("idres") String idReservation){
        return etudiantService.affecterEtudiantAReservation(nomEt,prenomEt,idReservation);
    }
}
