package com.esprit.tic.twin.project_backend.repositories;

import com.esprit.tic.twin.project_backend.entities.Foyer;
import com.esprit.tic.twin.project_backend.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface FoyerRepository extends JpaRepository<Foyer,Long> {
    Foyer findByNomFoyer(String nomFoyer);
    Foyer findByNomFoyerAndCapaciteFoyer(String nomFoyer,Long capacite);
    List<Foyer> findByUniversite_NomUniversite(String nomUniversite);

    List<Foyer> findByBlocsNomBloc(String s);
    List<Foyer> findByUniversiteNomUniversiteAndBlocsNomBloc(String nomUniversite, String nomBloc);

    Foyer findByIdFoyer(Long idFoyer);
     Foyer findFoyerByNomFoyer(String nomFoyer);


}
