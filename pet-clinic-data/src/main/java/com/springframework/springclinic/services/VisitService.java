package com.springframework.springclinic.services;

import com.springframework.springclinic.model.Visit;

import java.util.Set;

public interface VisitService extends CrudService<Visit, Long>{

    Visit findById(Long id);

    Visit save(Visit visit);

    Set<Visit> findAll();
}
