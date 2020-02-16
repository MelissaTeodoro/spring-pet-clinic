package com.springframework.springclinic.bootstrap;

import com.springframework.springclinic.model.Owner;
import com.springframework.springclinic.model.Vet;
import com.springframework.springclinic.services.OwnerService;
import com.springframework.springclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final VetService vetService;
    private final OwnerService ownerService;

    public DataLoader(VetService vetService, OwnerService ownerService) {
        this.vetService = vetService;
        this.ownerService = ownerService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Rickchen");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Chris");
        owner2.setLastName("Follks");
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
