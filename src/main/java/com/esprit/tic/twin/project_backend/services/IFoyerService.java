package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.entities.Foyer;
import com.esprit.tic.twin.project_backend.entities.Universite;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IFoyerService {
    List<Foyer> retrieveAll();

    Foyer addFoyer(Foyer f);

    Foyer updateFoyer(Foyer f);

    Foyer retriveFoyeyr(Long idFoyer);

    void removeFoyer (Long idFoyer);

    Universite addFoyerAuniversite(long idFoyer, String nomUniversite);

    Universite desaffecterFoyerAUniversite(Long idFoyer);
}
