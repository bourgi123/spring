package com.esprit.tic.twin.project_backend.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     long idEtudiant ;
     String nomEt;
     String prenomEt;
      long cin;
     String ecole;
   /* @Temporal(TemporalType.DATE)
    private Date dateNaissance;*/
   @Enumerated(EnumType.STRING)
     TypeEtudiant typeEtudiant ;
     LocalDate dateNaissance;
    @ManyToMany(cascade = CascadeType.ALL)
     Set<Reservation> reservations ;

    @OneToMany(mappedBy = "etudiant")
     Set<Tache> tacheSet;

    @OneToOne
     Tache tache;

    @Column(nullable = false)
    Float montantInscription = 500.0f;
}

