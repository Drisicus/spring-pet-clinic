package es.springwebapp.springpetclinic.services.map;

import es.springwebapp.springpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    long OWNER_ID = 1L;
    String OWNER_LASTNAME = "Gotera";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(OWNER_ID).lastName(OWNER_LASTNAME).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        assertTrue(Objects.nonNull(ownerServiceMap.findById(OWNER_ID)));
    }

    @Test
    void save() {
        long owner2Id = 2L;
        Owner owner2 = Owner.builder().id(owner2Id).build();
        assertEquals(owner2Id, ownerServiceMap.save(owner2).getId());
    }

    @Test
    void saveNoId() {
        Owner owner2 = new Owner();
        Owner savedOwner = ownerServiceMap.save(owner2);
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void deleteById() {
        ownerServiceMap.delete(ownerServiceMap.findById(OWNER_ID));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.deleteById(OWNER_ID);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName(OWNER_LASTNAME);
        assertNotNull(owner);
        assertEquals(OWNER_LASTNAME, owner.getLastName());
    }
}