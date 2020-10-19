package es.springwebapp.springpetclinic.services.map;

import es.springwebapp.springpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetMapServiceTest {

    private PetServiceMap petServiceMap;

    private final Long petId = 1L;

    @BeforeEach
    void setUp() {
        petServiceMap = new PetServiceMap();
        petServiceMap.save(Pet.builder().id(petId).build());
    }

    @Test
    void findAll() {
        Set<Pet> petSet = petServiceMap.findAll();
        assertEquals(1, petSet.size());
    }

    @Test
    void findByIdExistingId() {
        Pet pet = petServiceMap.findById(petId);
        assertEquals(petId, pet.getId());
    }

    @Test
    void findByIdNotExistingId() {
        Pet pet = petServiceMap.findById(5L);
        assertNull(pet);
    }

    @Test
    void findByIdNullId() {
        Pet pet = petServiceMap.findById(null);
        assertNull(pet);
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Pet pet2 = Pet.builder().id(id).build();
        Pet savedPet = petServiceMap.save(pet2);
        assertEquals(id, savedPet.getId());
    }

    @Test
    void saveDuplicateId() {
        Long id = 1L;
        Pet pet2 = Pet.builder().id(id).build();
        Pet savedPet = petServiceMap.save(pet2);
        assertEquals(id, savedPet.getId());
        assertEquals(1, petServiceMap.findAll().size());
    }

    @Test
    void saveNoId() {
        Pet savedPet = petServiceMap.save(Pet.builder().build());
        assertNotNull(savedPet);
        assertNotNull(savedPet.getId());
        assertEquals(2, petServiceMap.findAll().size());
    }

    @Test
    void deletePet() {
        petServiceMap.delete(petServiceMap.findById(petId));
        assertEquals(0, petServiceMap.findAll().size());
    }

    @Test
    void deleteWithWrongId() {
        Pet pet = Pet.builder().id(5L).build();
        petServiceMap.delete(pet);
        assertEquals(1, petServiceMap.findAll().size());
    }

    @Test
    void deleteWithNullId() {
        Pet pet = Pet.builder().build();
        petServiceMap.delete(pet);
        assertEquals(1, petServiceMap.findAll().size());
    }

    @Test
    void deleteNull() {
        petServiceMap.delete(null);
        assertEquals(1, petServiceMap.findAll().size());
    }

    @Test
    void deleteByIdCorrectId() {
        petServiceMap.deleteById(petId);
        assertEquals(0, petServiceMap.findAll().size());
    }

    @Test
    void deleteByIdWrongId() {
        petServiceMap.deleteById(5L);
        assertEquals(1, petServiceMap.findAll().size());
    }

    @Test
    void deleteByIdNullId() {
        petServiceMap.deleteById(null);
        assertEquals(1, petServiceMap.findAll().size());
    }
}