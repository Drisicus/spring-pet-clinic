package es.springwebapp.springpetclinic.services.springDataJPA;

import es.springwebapp.springpetclinic.model.Owner;
import es.springwebapp.springpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
class OwnerSDServiceTest {

    String LAST_NAME = "Smith";

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDService ownerSDService;

    Owner owner;

    @BeforeEach
    void setUp(){
        owner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        assertEquals(LAST_NAME, ownerSDService.findByLastName(LAST_NAME).getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).lastName("Owner1").build());
        owners.add(Owner.builder().id(2L).lastName("Owner2").build());

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> returnedOwners = ownerSDService.findAll();
        assertNotNull(returnedOwners);
        assertEquals(2, returnedOwners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
        Owner returnedOwner = ownerSDService.findById(1L);
        assertNotNull(returnedOwner);
        assertEquals(1L, returnedOwner.getId());
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner returnedOwner = ownerSDService.findById(1L);
        assertNull(returnedOwner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(owner);
        Owner savedOwner = ownerSDService.save(ownerToSave);
        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        ownerSDService.delete(owner);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDService.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }
}