package com.esprit.tic.twin.project_backend.repositories;

import com.esprit.tic.twin.project_backend.entities.Foyer;
import com.esprit.tic.twin.project_backend.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UniversityRepository extends JpaRepository<Universite,Long> {

    Universite findByNomUniversite(String nom);
    Universite findUniversitesByNomUniversite(String nom);

    List<Universite> findUniversitesByFoyer(Foyer foyer);


}
