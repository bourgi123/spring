package com.esprit.tic.twin.project_backend.services;


import com.esprit.tic.twin.project_backend.entities.Tache;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ITacheService {
    List<Tache> addTasksAndAffectToEtudiant (List<Tache> tasks, String nomEt, String prenomEt ) ;

}
