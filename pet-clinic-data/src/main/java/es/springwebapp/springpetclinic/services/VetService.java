package es.springwebapp.springpetclinic.services;

import es.springwebapp.springpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet findByLastName(String lastName);

    Set<Vet> findAll();

    Vet save(Vet vet);

}
