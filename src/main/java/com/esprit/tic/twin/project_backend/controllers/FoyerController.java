package com.esprit.tic.twin.project_backend.controllers;

import com.esprit.tic.twin.project_backend.entities.Bloc;
import com.esprit.tic.twin.project_backend.entities.Foyer;
import com.esprit.tic.twin.project_backend.entities.Universite;
import com.esprit.tic.twin.project_backend.services.IFoyerService;
import com.esprit.tic.twin.project_backend.services.IUniversityService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foyer")
@AllArgsConstructor
public class FoyerController {

    IFoyerService foyerService;
    IUniversityService universityService;

    @PutMapping("/affecterFoyerAUniversite/{idFoyer}/{nomUni}")
    @ResponseBody
    public Universite affecterFoyerAUniversite(@PathVariable long idFoyer, @PathVariable("nomUni") String nomUniversite) {
        Universite universiteCreated = foyerService.addFoyerAuniversite(idFoyer, nomUniversite);
        return universiteCreated ;
    }

    @PutMapping("/desaffecterFoyerAUniversite/{idFoyer}")
    @ResponseBody
    public Universite desaffecterFoyerAUniversite(@PathVariable("idFoyer") Long idFoyer) {
        System.out.println("API called with idFoyer: " + idFoyer);
        return foyerService.desaffecterFoyerAUniversite(idFoyer);
    }

}
