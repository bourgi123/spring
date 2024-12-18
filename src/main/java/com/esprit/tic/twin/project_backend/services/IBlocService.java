package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.entities.Bloc;
import com.esprit.tic.twin.project_backend.entities.Foyer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IBlocService {
    List<Bloc> retrieveAll();

    Bloc addBloc(Bloc b);

    Bloc updateBloc(Bloc b);

    Optional<Bloc> retriveBloc(Long idbloc);

    void removeBloc (Long idBloc);

    Foyer addFoyerWithBloc(Foyer f);
}
