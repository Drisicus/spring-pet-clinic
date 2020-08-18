package es.springwebapp.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import es.springwebapp.springpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
