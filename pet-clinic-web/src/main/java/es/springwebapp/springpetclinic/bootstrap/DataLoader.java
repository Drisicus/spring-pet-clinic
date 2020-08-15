package es.springwebapp.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import es.springwebapp.springpetclinic.model.Owner;
import es.springwebapp.springpetclinic.model.Vet;
import es.springwebapp.springpetclinic.services.OwnerService;
import es.springwebapp.springpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService){
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setFirstName("Al");
        owner.setLastName("Anniston");
        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bob");
        owner2.setLastName("Bottleleg");
        ownerService.save(owner2);

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
