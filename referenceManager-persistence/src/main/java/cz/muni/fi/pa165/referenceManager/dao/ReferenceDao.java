package cz.muni.fi.pa165.referenceManager.dao;

import cz.muni.fi.pa165.referenceManager.entity.Reference;

import java.util.List;

public interface ReferenceDao {
    void create(Reference r);

    void update(Reference r);

    void remove(Reference r);

    Reference findById(Long id);

    List<Reference> findAll();
}
