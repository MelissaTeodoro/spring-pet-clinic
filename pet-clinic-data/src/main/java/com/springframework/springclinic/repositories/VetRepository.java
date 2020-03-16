package com.springframework.springclinic.repositories;

import com.springframework.springclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
