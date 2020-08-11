package es.springwebapp.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import es.springwebapp.springpetclinic.model.Owner;
import es.springwebapp.springpetclinic.model.Vet;
import es.springwebapp.springpetclinic.services.OwnerService;
import es.springwebapp.springpetclinic.services.VetService;
import es.springwebapp.springpetclinic.services.map.OwnerServiceMap;
import es.springwebapp.springpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(){
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Al");
        owner.setFirstName("Anniston");

        Owner owner2 = new Owner();
        owner.setId(2L);
        owner.setFirstName("Bob");
        owner.setFirstName("Bottleleg");

        ownerService.save(owner);
        ownerService.save(owner2);

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Connie");
        vet.setFirstName("Connor");

        Vet vet2 = new Vet();
        vet.setId(2L);
        vet.setFirstName("Dan");
        vet.setFirstName("Davison");

        vetService.save(vet);
        vetService.save(vet2);
    }
}
