package es.springwebapp.springpetclinic.services.springDataJPA;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import es.springwebapp.springpetclinic.model.Specialty;
import es.springwebapp.springpetclinic.repositories.SpecialtyRepository;
import es.springwebapp.springpetclinic.services.SpecialtyService;

@Service
@Profile("springdatajpa")
public class SpecialtySDService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtySDService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
