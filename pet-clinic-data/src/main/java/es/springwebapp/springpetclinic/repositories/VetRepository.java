package es.springwebapp.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import es.springwebapp.springpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
