package com.esprit.tic.twin.project_backend.controllers;

import com.esprit.tic.twin.project_backend.entities.Bloc;
import com.esprit.tic.twin.project_backend.entities.Chambre;
import com.esprit.tic.twin.project_backend.entities.TypeChambre;
import com.esprit.tic.twin.project_backend.services.IChambreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreController {
    IChambreService chambreService;


    @PutMapping("/affecterChambresABloc/{nombloc}")
    public Bloc affecterChambresABloc(@RequestBody List<Long> numChambre, @PathVariable ("nombloc") String nomBloc)
    {
       return chambreService.affecterChambresABloc(numChambre,nomBloc);
    }

    @GetMapping("/getChambresParNomBloc/{nomBloc}")
    public List<Chambre> getChambresParNomBloc(@PathVariable("nomBloc") String nomBloc) {
        return chambreService.getChambresParNomBloc(nomBloc);
    }

    @GetMapping("/nbChambreParTypeEtBloc/{typec}/{idb}")
    public long nbChambreParTypeEtBloc(@PathVariable("typec") TypeChambre type,@PathVariable("idb") long idBloc) {
        return chambreService.nbChambreParTypeEtBloc(type,idBloc);
    }

}
