package es.springwebapp.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import es.springwebapp.springpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
