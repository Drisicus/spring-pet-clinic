package es.springwebapp.springpetclinic.formatters;

import es.springwebapp.springpetclinic.model.PetType;
import es.springwebapp.springpetclinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Objects;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String petTypeName, Locale locale) throws ParseException {
        PetType petTypeFound = petTypeService.findAll().stream().filter(petType -> petType.getName().equals(petTypeName))
                .findFirst().orElse(null);
        if(Objects.isNull(petTypeFound)){
            throw new ParseException("type not found: " + petTypeName, 0);
        }
        return petTypeFound;
    }
}
