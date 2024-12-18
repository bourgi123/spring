package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.entities.Etudiant;
import com.esprit.tic.twin.project_backend.entities.Tache;
import com.esprit.tic.twin.project_backend.repositories.EtudiantRepository;
import com.esprit.tic.twin.project_backend.repositories.TacheRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class TacheServiceImp implements  ITacheService{
    TacheRepository tacheRepository;
    EtudiantRepository etudiantRepository;

    @Override
    public List<Tache> addTasksAndAffectToEtudiant(@RequestBody List<Tache> tasks, String nomEt, String prenomEt) {
        Etudiant etudiant=etudiantRepository.findEtudiantByNomEtAndPrenomEt(nomEt,prenomEt);

        for (Tache task:tasks)
        {
            etudiant.setTache(task);
            tacheRepository.save(task);
        }
        etudiantRepository.save(etudiant);
        return tasks;
    }
    //ken 3tani bch nsavi list a la fois mathalan : addtasks donc naaml : tacheRepositor.saveAll()
}
