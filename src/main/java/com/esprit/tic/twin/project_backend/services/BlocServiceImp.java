package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.entities.Bloc;
import com.esprit.tic.twin.project_backend.entities.Chambre;
import com.esprit.tic.twin.project_backend.entities.Foyer;
import com.esprit.tic.twin.project_backend.repositories.BlocRepository;
import com.esprit.tic.twin.project_backend.repositories.ChambreRepository;
import com.esprit.tic.twin.project_backend.repositories.FoyerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class BlocServiceImp implements IBlocService{
BlocRepository blocRepository;
FoyerRepository foyerRepository;
ChambreRepository chambreRepository;
    @Override
    public List<Bloc> retrieveAll() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Bloc updateBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Optional<Bloc> retriveBloc(Long idbloc) {
        return blocRepository.findById(idbloc);
    }

    @Override
    public void removeBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public Foyer addFoyerWithBloc(Foyer f) {
        Set<Bloc> blocs = f.getBlocs();
        for (Bloc bloc:blocs)
        {
            bloc.setFoyer(f);
        }
        foyerRepository.save(f);
        return f;
    }
/*
        @Scheduled(cron = "* 0/1 * * * *")
        public void listeChambresParBloc() {
            List<Bloc> blocs = blocRepository.findAll();
            blocs.forEach(bloc -> {
                log.info("bloc : " + bloc.getNomBloc() + " ayant une capacité de : " + bloc.getCapaciteBloc());
                log.info("Liste des chambres du bloc " + bloc.getNomBloc() + " :");
                List<Chambre> chambres = chambreRepository.findChambresByBloc(bloc);
                chambres.forEach(chambre -> {
                    log.info("chambre numéro " + chambre.getNumeroChambre() + " de type " + chambre.getTypeC());
                });
            });
        }*/

}
