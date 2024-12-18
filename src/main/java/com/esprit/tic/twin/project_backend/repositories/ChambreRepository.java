package com.esprit.tic.twin.project_backend.repositories;

import com.esprit.tic.twin.project_backend.entities.Bloc;
import com.esprit.tic.twin.project_backend.entities.Chambre;
import com.esprit.tic.twin.project_backend.entities.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Long> {


    List<Chambre> findByBlocNomBloc(String nom);
    Chambre findByNumeroChambre(Long numerochambre);


    List<Chambre> findByTypeCAndBlocNomBloc(String type,String nom);
    List<Chambre> findByReservationSet_EstValide(Boolean valide);

    List<Chambre> findChambresByBloc(Bloc bloc);

    List<Chambre> findByBlocNomBlocAndBlocCapaciteBloc(String nom,long capacite);
    @Query("select c from Chambre c where c.bloc.nomBloc=:nom")
    List<Chambre> retrieveChambreByBloc(@Param("nom")String nom);
    @Query("select c from Chambre c where c.typeC=:type and c.bloc.nomBloc=:nom ")
    List<Chambre> retrievechambrebytype(@Param("nom")String nom,@Param("type")String type);
    @Query("SELECT c FROM Chambre c JOIN c.reservationSet r WHERE r.estValide = :valide")
    List<Chambre> retrieveChambreByValidity(@Param("valide")Boolean valide);
    @Query("select c from Chambre c where c.bloc.nomBloc=:nom and c.bloc.capaciteBloc>:nombre")
    List<Chambre> retrieveChambreByNomBlocAndCapacity(@Param("nom")String nom,@Param("nombre")long nombre);

    @Query("select count(c) from Chambre c where c.bloc.idBloc=:id_bloc and c.typeC=:type_c")
    Long countChambreByTypeCAndBlocIdBloc(@Param("type_c") TypeChambre type, @Param("id_bloc") Long idBloc);

    @Query("select count(c) from Chambre c where c.typeC=:type_c")
    Double countChambreByTypeC(@Param("type_c") TypeChambre type_c);

    @Query("select count(c) from Chambre c ")
    Double countChambre();


}

