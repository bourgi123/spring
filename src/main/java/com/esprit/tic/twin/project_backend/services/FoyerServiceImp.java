package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.entities.Foyer;
import com.esprit.tic.twin.project_backend.entities.Universite;
import com.esprit.tic.twin.project_backend.repositories.FoyerRepository;
import com.esprit.tic.twin.project_backend.repositories.UniversityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImp implements IFoyerService{

    FoyerRepository foyerRepository;
    UniversityRepository universityRepository;

    @Override
    public List<Foyer> retrieveAll() {
            return foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retriveFoyeyr(Long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(Long idFoyer) {
      foyerRepository.deleteById(idFoyer);
    }

    @Override
    public Universite addFoyerAuniversite(long idFoyer, String nomUniversite) {
        Universite universite = universityRepository.findUniversitesByNomUniversite(nomUniversite);
        // université est le fils
        Foyer foyer = foyerRepository.findById(idFoyer).get();
        //parent.set(child)
        foyer.setUniversite(universite);
        // sauvegarder l'objet université avec le foyer affecté
        //sauvegarder l'objet modifié
        universityRepository.save(universite);
        return universite;
    }

    @Override
    public Universite desaffecterFoyerAUniversite(Long idFoyer) {
        // Step 1: Retrieve the foyer by id
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer introuvable"));

        // Step 2: Check if the foyer is associated with a university
        Universite universite = foyer.getUniversite();  // This is assuming Foyer has a reference to Universite

        if (universite != null) {
            // Step 3: Remove the link from Foyer (set Universite to null in the Foyer entity)
            foyer.setUniversite(null);  // Unlink the Foyer from the Universite

            // Step 4: Save the updated Foyer entity (set the 'idUniversite' to null in DB)
            foyerRepository.save(foyer);

            // Step 5: Optionally, return the updated Universite (or just null if not needed)
            return universite;
        }

        throw new RuntimeException("No university linked to this foyer");
    }

}



