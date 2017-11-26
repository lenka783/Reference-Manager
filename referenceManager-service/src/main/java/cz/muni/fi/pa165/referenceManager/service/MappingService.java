package cz.muni.fi.pa165.referenceManager.service;

import org.dozer.Mapper;

import java.util.Collection;
import java.util.List;

public interface MappingService {

    public <T> List<T> mapTo(Collection<?> objects, Class<T> mapToClass);

    public <T> T mapTo(Object u, Class<T> mapToClass);

    public Mapper getMapper();
}
