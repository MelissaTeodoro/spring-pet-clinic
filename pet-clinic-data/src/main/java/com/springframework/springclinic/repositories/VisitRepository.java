package com.springframework.springclinic.repositories;

import com.springframework.springclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
