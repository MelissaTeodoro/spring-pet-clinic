package com.springframework.springclinic.services.map.springdatajpa;

import com.springframework.springclinic.model.Vet;
import com.springframework.springclinic.repositories.PetRepository;
import com.springframework.springclinic.repositories.PetTypeRepository;
import com.springframework.springclinic.repositories.VetRepository;
import com.springframework.springclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private VetRepository vetRepository;
    private PetRepository petRepository;
    private PetTypeRepository petTypeRepository;

    public VetSDJpaService(VetRepository vetRepository, PetRepository petRepository,
                           PetTypeRepository petTypeRepository) {
        this.vetRepository = vetRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }
}
