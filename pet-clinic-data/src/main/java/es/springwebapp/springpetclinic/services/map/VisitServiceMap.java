package es.springwebapp.springpetclinic.services.map;

import es.springwebapp.springpetclinic.model.Visit;
import es.springwebapp.springpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public Visit save(Visit visit) {
        boolean invalidVisit = Objects.isNull(visit.getPet()) || Objects.isNull(visit.getPet().getOwner())
                || Objects.isNull(visit.getPet().getId()) || Objects.isNull(visit.getPet().getOwner().getId());

        if(invalidVisit){
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
