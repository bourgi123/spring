package com.esprit.tic.twin.project_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     long idChmbre;
     long numeroChambre;
    @Enumerated(EnumType.STRING)
     TypeChambre typeC;

    @ManyToOne
     Bloc bloc;

    @OneToMany
    @JsonIgnore
     Set<Reservation> reservationSet;


}
