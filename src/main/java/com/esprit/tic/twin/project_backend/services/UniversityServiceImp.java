package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.repositories.UniversityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UniversityServiceImp implements  IUniversityService{
    UniversityRepository universiteRepository;
}
