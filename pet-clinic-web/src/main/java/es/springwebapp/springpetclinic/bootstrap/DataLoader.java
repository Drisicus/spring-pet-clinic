package es.springwebapp.springpetclinic.bootstrap;

import es.springwebapp.springpetclinic.model.*;
import es.springwebapp.springpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        if(ownerService.findAll().isEmpty()) {
            loadData();
        }
    }

    private void loadData() {
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

        Pet ownerPet = new Pet();
        ownerPet.setName("Al doggo");
        ownerPet.setBirthDate(LocalDate.now());
        ownerPet.setPetType(dog);
        ownerPet.setOwner(owner);
        owner.getPets().add(ownerPet);

        // save owner and its pet
        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bob");
        owner2.setLastName("Bottleleg");
        owner2.setAddress("Boby Flat");
        owner2.setCity("Old York");
        owner2.setTelephone("54321");

        Pet owner2Pet = new Pet();
        owner2Pet.setName("Bob catto");
        owner2Pet.setBirthDate(LocalDate.now());
        owner2Pet.setPetType(cat);
        owner2Pet.setOwner(owner2);
        owner2.getPets().add(owner2Pet);

        ownerService.save(owner2);

        Visit visit = new Visit();
        visit.setDate(LocalDate.now());
        visit.setDescription("Check Bob Catto");
        visit.setPet(owner2Pet);
        visitService.save(visit);

        Specialty specialty = new Specialty();
        specialty.setDescription("Puppy holder");
        specialtyService.save(specialty);

        Specialty specialty2 = new Specialty();
        specialty2.setDescription("Kitty Kisser");
        specialtyService.save(specialty2);

        Vet vet = new Vet();
        vet.setFirstName("Connie");
        vet.setLastName("Connor");
        vet.getSpecialties().add(specialty);
        vetService.save(vet);

        Vet vet2 = new Vet();
        vet2.setFirstName("Dan");
        vet2.setLastName("Davison");
        vet2.getSpecialties().add(specialty);
        vet2.getSpecialties().add(specialty2);
        vetService.save(vet2);
    }
}
