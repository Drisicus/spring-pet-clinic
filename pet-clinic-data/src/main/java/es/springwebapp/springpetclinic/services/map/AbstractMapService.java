package es.springwebapp.springpetclinic.services.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import es.springwebapp.springpetclinic.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){
        if(Objects.nonNull(object)){
            object.setId(Objects.isNull(object.getId()) ? getNextId() : object.getId());
            map.put(object.getId(), object);
        } else{
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId(){
        return map.keySet().stream().max(Comparator.comparingLong(Long::longValue)).orElse(0L) + 1;
    }
}
