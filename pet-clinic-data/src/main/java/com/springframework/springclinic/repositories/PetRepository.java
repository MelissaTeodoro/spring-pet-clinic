package com.springframework.springclinic.repositories;

import com.springframework.springclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
