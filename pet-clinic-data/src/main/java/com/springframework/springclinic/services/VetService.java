package com.springframework.springclinic.services;

import com.springframework.springclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet saveVet(Vet vet);

    Set<Vet> findAll();
}
