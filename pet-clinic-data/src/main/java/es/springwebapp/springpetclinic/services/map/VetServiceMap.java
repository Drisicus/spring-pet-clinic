package es.springwebapp.springpetclinic.services.map;

import java.util.Objects;
import java.util.Set;

import org.springframework.stereotype.Service;

import es.springwebapp.springpetclinic.model.Specialty;
import es.springwebapp.springpetclinic.model.Vet;
import es.springwebapp.springpetclinic.services.SpecialtyService;
import es.springwebapp.springpetclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if(!object.getSpecialties().isEmpty()){
            object.getSpecialties().forEach(specialty -> {
                if(Objects.isNull(specialty.getId())){
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }
}
