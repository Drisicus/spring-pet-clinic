package es.springwebapp.springpetclinic.services.map;

import java.util.Objects;
import java.util.Set;

import es.springwebapp.springpetclinic.model.Visit;
import es.springwebapp.springpetclinic.services.VisitService;

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

        if(!invalidVisit){
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
