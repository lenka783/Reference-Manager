package cz.muni.fi.pa165.referenceManager.dao;

import cz.muni.fi.pa165.referenceManager.entity.Tag;

import java.util.List;

/**
 * @author Andrej Staruch
 */
public interface TagDao {
    void create(Tag t);

    Tag update(Tag t);

    void remove(Tag t);

    Tag findById(Long id);

    List<Tag> findAll();
}
