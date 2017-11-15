package dao;

import entity.Tag;

import java.util.List;

/**
 * @author Andrej Staruch
 */
public interface TagDao {
    void create(Tag t);

    void update(Tag t);

    void remove(Tag t);

    Tag findById(Long id);

    List<Tag> findAll();
}
