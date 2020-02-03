package com.springframework.springclinic.services;

import com.springframework.springclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet savePet(Pet pet);

    Set<Pet> findAll();
}
