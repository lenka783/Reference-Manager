package cz.fi.muni.pa165.referenceManager.service;

import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dozer.Mapper;

@Service
public class MappingServiceImpl {

    @Inject
    Mapper dozerMapper;

    public <T> List<T> mapTo(Collection<?> objects, Class<T> mapToClass) {
        List<T> mappedCollection = new ArrayList<>();
        for (Object object : objects) {
            mappedCollection.add(dozerMapper.map(object, mapToClass));
        }
        return mappedCollection;
    }

    public <T> T mapTo(Object u, Class<T> mapToClass) {
        return dozerMapper.map(u, mapToClass);
    }

    public Mapper getMapper() {
        return dozerMapper;
    }
}
