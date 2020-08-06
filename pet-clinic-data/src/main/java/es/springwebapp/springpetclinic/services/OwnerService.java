package es.springwebapp.springpetclinic.services;

import es.springwebapp.springpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findById(Long id);

    Owner findByLastName(String lastName);

    Set<Owner> findAll();

    Owner save(Owner owner);

}