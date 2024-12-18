package com.esprit.tic.twin.project_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Reservation {
    @Id
     String idReservation;
     Date anneeUniversitaire;
     boolean estValide;

    @ManyToMany(mappedBy = "reservations")
    @JsonIgnore
     Set<Etudiant> etudiantSet;

}
