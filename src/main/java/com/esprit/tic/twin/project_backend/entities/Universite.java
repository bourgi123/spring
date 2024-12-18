package com.esprit.tic.twin.project_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Universite {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
     long idUniversite;
     String nomUniversite;
     String addresse;
@OneToOne(mappedBy = "universite")
@JsonIgnore
         Foyer foyer;
}
