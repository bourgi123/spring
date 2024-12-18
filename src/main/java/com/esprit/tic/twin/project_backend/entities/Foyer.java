package com.esprit.tic.twin.project_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.management.ConstructorParameters;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     long idFoyer;
     String nomFoyer;
     long capaciteFoyer;

     public Foyer(long id ){
         this.idFoyer=id;
     }

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
     Universite universite;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "foyer",fetch = FetchType.EAGER)
     Set<Bloc> blocs;
}
