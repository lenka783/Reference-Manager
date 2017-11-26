package cz.muni.fi.pa165.referenceManager.service;

import cz.muni.fi.pa165.referenceManager.entity.Reference;
import cz.muni.fi.pa165.referenceManager.entity.Tag;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author Lenka Smitalova
 */
@Service
public interface TagService {

    Tag create(Tag tag);

    void updateTagName(Long tagId, String newName);

    void remove(Tag tag);

    Tag findById(Long tagId);

    Collection<Tag> findAllTags();

    void addReference(Tag tag, Reference reference);

    void removeReference(Tag tag, Reference reference);
}
