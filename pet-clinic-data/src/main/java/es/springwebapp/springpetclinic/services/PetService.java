package es.springwebapp.springpetclinic.services;

import es.springwebapp.springpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Set<Pet> findAll();

    Pet save(Pet pet);

}
