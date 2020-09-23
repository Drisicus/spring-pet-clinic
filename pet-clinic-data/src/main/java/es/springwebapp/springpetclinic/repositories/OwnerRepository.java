package es.springwebapp.springpetclinic.repositories;

import es.springwebapp.springpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
    Set<Owner> findAllByLastNameLike(String lastName);
}
