package com.esprit.tic.twin.project_backend.controllers;

import com.esprit.tic.twin.project_backend.entities.Bloc;
import com.esprit.tic.twin.project_backend.entities.Foyer;
import com.esprit.tic.twin.project_backend.services.IBlocService;
import com.esprit.tic.twin.project_backend.services.IChambreService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bloc")
@AllArgsConstructor
@Slf4j
public class BlocController {

    private final IBlocService blocService;
    private final IChambreService chambreService;

    // Récupérer tous les blocs
    @GetMapping("/retrieve-all-blocs")
    public ResponseEntity<List<Bloc>> retrieveAllBlocs() {
        try {
            List<Bloc> blocs = blocService.retrieveAll();

            // Filtrer ou transformer les blocs pour n'inclure que les informations nécessaires
            List<Bloc> filteredBlocs = blocs.stream()
                    .map(bloc -> {
                        // Créer un nouvel objet Bloc ou utiliser un DTO si nécessaire
                        Bloc filteredBloc = new Bloc();
                        filteredBloc.setIdBloc(bloc.getIdBloc());
                        filteredBloc.setNomBloc(bloc.getNomBloc());
                        filteredBloc.setCapaciteBloc(bloc.getCapaciteBloc());

                        // Ajouter les informations du foyer
                        if (bloc.getFoyer() != null) {
                            Foyer foyer = bloc.getFoyer();
                            filteredBloc.setFoyer(new Foyer(foyer.getIdFoyer()));
                        }

                        return filteredBloc;
                    })
                    .collect(Collectors.toList());

            log.info("Blocs récupérés avec succès : {}", filteredBlocs);
            return new ResponseEntity<>(filteredBlocs, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Erreur lors de la récupération des blocs : ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    

    // Ajouter un nouveau bloc
    @PostMapping("/add-bloc")
    public ResponseEntity<Bloc> addBloc(@RequestBody Map<String,Object> blocRequest) {
        try {

            Bloc bloc = new Bloc();
            Bloc createdBloc = blocService.addBloc(bloc);
            log.info("Bloc ajouté avec succès : {}", createdBloc);
            return new ResponseEntity<>(createdBloc, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Erreur lors de l'ajout du bloc : ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


   @PutMapping("/update-bloc/{id}")
    public ResponseEntity<Bloc> updateBloc(@PathVariable int id, @RequestBody Bloc bloc) {
        try {
            Bloc updatedBloc = blocService.updateBloc(bloc);
            log.info("Bloc mis à jour avec succès : {}", updatedBloc);
            return new ResponseEntity<>(updatedBloc, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Erreur lors de la mise à jour du bloc : ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Supprimer un bloc
    @DeleteMapping("/delete-bloc/{id}")
    public ResponseEntity<Void> deleteBloc(@PathVariable Long id) {
        try {
            blocService.removeBloc(id);
            log.info("Bloc supprimé avec succès : {}", id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }  catch (Exception e) {
            log.error("Erreur lors de la suppression du bloc : ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/addFoyerWithBloc")
    public Foyer addFoyerWithBloc(@RequestBody Foyer f)
    {
        return blocService.addFoyerWithBloc(f);
    }


}
