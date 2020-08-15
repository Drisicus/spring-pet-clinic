package es.springwebapp.springpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import es.springwebapp.springpetclinic.model.Owner;
import es.springwebapp.springpetclinic.model.Pet;
import es.springwebapp.springpetclinic.model.PetType;
import es.springwebapp.springpetclinic.model.Vet;
import es.springwebapp.springpetclinic.services.OwnerService;
import es.springwebapp.springpetclinic.services.PetTypeService;
import es.springwebapp.springpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

        Owner owner = new Owner();
        owner.setFirstName("Al");
        owner.setLastName("Anniston");
        owner.setAddress("Al House Address");
        owner.setCity("New York");
        owner.setTelephone("12345");
        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bob");
        owner2.setLastName("Bottleleg");
        owner2.setAddress("Boby Flat");
        owner2.setCity("Old York");
        owner2.setTelephone("54321");
        ownerService.save(owner2);

        Pet ownerPet = new Pet();
        ownerPet.setName("Al doggo");
        ownerPet.setBirthDate(LocalDate.now());
        ownerPet.setPetType(dog);
        ownerPet.setOwner(owner);
        owner.getPets().add(ownerPet);

        Pet owner2Pet = new Pet();
        owner2Pet.setName("Bob catto");
        owner2Pet.setBirthDate(LocalDate.now());
        owner2Pet.setPetType(cat);
        owner2Pet.setOwner(owner2);
        owner2.getPets().add(owner2Pet);

        Vet vet = new Vet();
        vet.setFirstName("Connie");
        vet.setLastName("Connor");
        vetService.save(vet);

        Vet vet2 = new Vet();
        vet2.setFirstName("Dan");
        vet2.setLastName("Davison");
        vetService.save(vet2);
    }
}
