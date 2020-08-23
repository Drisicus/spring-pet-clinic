package es.springwebapp.springpetclinic.services;

import es.springwebapp.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
