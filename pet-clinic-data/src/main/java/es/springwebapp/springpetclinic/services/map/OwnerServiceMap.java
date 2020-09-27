package es.springwebapp.springpetclinic.services.map;

import es.springwebapp.springpetclinic.model.Owner;
import es.springwebapp.springpetclinic.model.Pet;
import es.springwebapp.springpetclinic.services.OwnerService;
import es.springwebapp.springpetclinic.services.PetService;
import es.springwebapp.springpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        Owner owner = null;
        if(Objects.nonNull(object)) {
            object.getPets().forEach(pet -> {
                boolean petHasPetType = Objects.nonNull(pet.getPetType());
                if (petHasPetType && Objects.isNull(pet.getPetType().getId())) {
                    pet.setPetType(petTypeService.save(pet.getPetType()));
                } else if (!petHasPetType) {
                    throw new RuntimeException("Pet requires a PetType");
                }
                if (Objects.isNull(pet.getId())) {
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            });
            owner = super.save(object);
        }
        return owner;
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return findAll().stream().filter(owner -> owner.getLastName().equalsIgnoreCase(lastName)).findFirst()
                .orElse(null);
    }

    @Override
    public Set<Owner> findAllByLastNameLike(String lastName) {
        Pattern pattern = Pattern.compile(lastName.replace("%", ".*"));
        return findAll().stream().filter(owner -> pattern.matcher(owner.getLastName()).matches()).collect(Collectors.toSet());
    }

}
