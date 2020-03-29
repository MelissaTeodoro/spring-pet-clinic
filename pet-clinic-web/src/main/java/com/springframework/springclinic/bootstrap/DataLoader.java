package com.springframework.springclinic.bootstrap;

import com.springframework.springclinic.model.*;
import com.springframework.springclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final VetService vetService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(VetService vetService, OwnerService ownerService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.vetService = vetService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatType = petTypeService.save(cat);

        System.out.println("Load Pets.......");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Rickchen");
        owner1.setAddress("123 Address");
        owner1.setCity("Miami");
        owner1.setTelephone("11922222222");

        Pet mykesPet = new Pet();
        mykesPet.setPetType(savedDogType);
        mykesPet.setOwner(owner1);
        mykesPet.setBirthDate(LocalDate.now());
        mykesPet.setName("Rosco");
        owner1.getPets().add(mykesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Chris");
        owner2.setLastName("Follks");
        owner2.setAddress("222 Address");
        owner2.setCity("Miami");
        owner2.setTelephone("11933333333");

        Pet fionasCat = new Pet();
        fionasCat.setPetType(savedCatType);
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setName("Just cat");
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(fionasCat);
        catVisit.setLocalDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners.......");

        Vet vet1 = new Vet();
        vet1.setFirstName("Mayhsa");
        vet1.setLastName("Christen");
        vet1.getSpecialities().add(radiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Carl");
        vet2.setLastName("Rohnster");
        vet2.getSpecialities().add(surgery);
        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Johan");
        vet3.setLastName("Carls");
        vet3.getSpecialities().add(dentistry);
        vetService.save(vet3);

        System.out.println("Loaded Vets.......");
    }
}
