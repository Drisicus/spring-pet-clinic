package es.springwebapp.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import es.springwebapp.springpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
