package com.esprit.tic.twin.project_backend.controllers;

import com.esprit.tic.twin.project_backend.entities.Tache;
import com.esprit.tic.twin.project_backend.services.ITacheService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TacheController {
    ITacheService tacheService;

    @PutMapping("/addTasksAndAffectToEtudiant/{nomEt}/{prenomEt}")
    public List<Tache> addTasksAndAffectToEtudiant(@RequestBody List<Tache> tasks, @PathVariable("nomEt") String nomEt, @PathVariable("prenomEt") String prenomEt){
        return  tacheService.addTasksAndAffectToEtudiant(tasks,nomEt,prenomEt);
    }
}
