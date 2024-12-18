package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.entities.Bloc;
import com.esprit.tic.twin.project_backend.entities.Chambre;
import com.esprit.tic.twin.project_backend.entities.TypeChambre;
import com.esprit.tic.twin.project_backend.repositories.BlocRepository;
import com.esprit.tic.twin.project_backend.repositories.ChambreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@AllArgsConstructor
@Slf4j
public class ChambreServiceImp implements IChambreService{
    ChambreRepository chambreRepository ;
    BlocRepository blocRepository ;


    @Override
    public List<Chambre> retrieveAllChambres() {
        return null;
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {
        Bloc bloc = blocRepository.findBlocByNomBloc(nomBloc);

        for(Long num : numChambre)
        {
            Chambre chambre=chambreRepository.findByNumeroChambre(num);
            chambre.setBloc(bloc);
            bloc.getChambreSet().add(chambre);
            chambreRepository.save(chambre);
        }
        blocRepository.save(bloc);
return bloc ;
    }

    @Override
    public List<Chambre> getChambresParNomBloc(String nomBloc) {
        List<Chambre> chambres=chambreRepository.findByBlocNomBloc(nomBloc);
        return chambres ;
    }

    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) {
        return chambreRepository.countChambreByTypeCAndBlocIdBloc(type,idBloc);
    }
    @Scheduled(fixedRate = 300000)
   public void pourcentageChambreParTypeChambre() {
     Double totalChambre = chambreRepository.countChambre();
     Double totalChambreSimple = chambreRepository.countChambreByTypeC(TypeChambre.SIMPLE);
     Double totalChambreDouble = chambreRepository.countChambreByTypeC(TypeChambre.DOUBLE);
     Double totalChambreTriple = chambreRepository.countChambreByTypeC(TypeChambre.TRIPLE);

     Double pSimple= totalChambreSimple/totalChambre;
     Double pDouble= totalChambreDouble/totalChambre;
     Double pTriple= totalChambreTriple/totalChambre;
     log.info("nbTotalChambre : "+totalChambre);
     log.info("le pourcentage de chambre pour le type SIMPLE : "+pSimple);
     log.info("le pourcentage de chambre pour le type Double : "+pDouble);
     log.info("le pourcentage de chambre pour le type TRIPLE : "+pTriple);



    }

}
