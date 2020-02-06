package com.springframework.springclinic.services;

import com.springframework.springclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
