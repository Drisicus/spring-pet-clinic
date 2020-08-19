package es.springwebapp.springpetclinic.services.springDataJPA;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import es.springwebapp.springpetclinic.model.Pet;
import es.springwebapp.springpetclinic.repositories.PetRepository;
import es.springwebapp.springpetclinic.services.PetService;

@Service
@Profile("springdatajpa")
public class PetSDService implements PetService {

    private final PetRepository petRepository;

    public PetSDService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}