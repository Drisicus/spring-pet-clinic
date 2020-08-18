package es.springwebapp.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import es.springwebapp.springpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
