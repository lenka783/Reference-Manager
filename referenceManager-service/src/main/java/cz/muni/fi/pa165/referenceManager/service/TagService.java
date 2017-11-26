package cz.muni.fi.pa165.referenceManager.service;

import cz.muni.fi.pa165.referenceManager.entity.Tag;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author Lenka Smitalova
 */
@Service
public interface TagService {

    void create(Tag tag);

    void update(Tag tag);

    void remove(Tag tag);

    Tag getTagById(Long id);

    Collection<Tag> getAllTags();
}
