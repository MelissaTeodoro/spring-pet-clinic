package com.springframework.springclinic.bootstrap;

import com.springframework.springclinic.model.Owner;
import com.springframework.springclinic.model.Pet;
import com.springframework.springclinic.model.PetType;
import com.springframework.springclinic.model.Vet;
import com.springframework.springclinic.services.OwnerService;
import com.springframework.springclinic.services.PetTypeService;
import com.springframework.springclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final VetService vetService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public DataLoader(VetService vetService, OwnerService ownerService, PetTypeService petTypeService) {
        this.vetService = vetService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatType = petTypeService.save(cat);

        System.out.println("Load Pets.......");

        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Rickchen");
        owner1.setAddress("123 Address");
        owner1.setCity("Miami");
        owner1.setTelephone("11922222222");

        Pet mykesPet = new Pet();
        mykesPet.setPetType(savedDogType);
        mykesPet.setOwner(owner1);
        mykesPet.setBirthDay(LocalDate.now());
        mykesPet.setNome("Rosco");
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
        fionasCat.setBirthDay(LocalDate.now());
        fionasCat.setNome("Just cat");
        owner1.getPets().add(fionasCat);

        ownerService.save(owner2);

        System.out.println("Load Owners.......");

        Vet vet1 = new Vet();
        vet1.setFirstName("Mayhsa");
        vet1.setLastName("Christen");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Carl");
        vet2.setLastName("Rohnster");
        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Johan");
        vet3.setLastName("Carls");
        vetService.save(vet3);

        System.out.println("Load Vets.......");
    }
}
