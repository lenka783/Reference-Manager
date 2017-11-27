package cz.muni.fi.pa165.referenceManager.service;

import cz.muni.fi.pa165.referenceManager.entity.Reference;
import cz.muni.fi.pa165.referenceManager.entity.Tag;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Interface representing TagService
 *
 * @author Lenka Smitalova
 */
@Service
public interface TagService {

    /**
     * Inserts a tag into database
     * @param tag tag to be inserted
     */
    void create(Tag tag);

    /**
     * Updates existing tag's name with a new name
     * @param tagId id of tag
     * @param newName new name of tag
     */
    void updateTagName(Long tagId, String newName);

    /**
     * Remove existing tag from database
     * @param tagId id of tag
     */
    void remove(Long tagId);

    /**
     * Finds existing tag in database
     * @param tagId id of tag
     * @return tag with given id if found, null otherwise
     */
    Tag findById(Long tagId);

    /**
     * Find all stored tags in database
     * @return all stored tags in database
     */
    Collection<Tag> findAllTags();

    /**
     * Creates mapping between tag and reference
     * @param tag tag to add reference
     * @param reference reference to be added
     */
    void addReference(Tag tag, Reference reference);

    /**
     * Remove mapping between tag and reference
     * @param tag tag having reference
     * @param reference reference to be removed
     */
    void removeReference(Tag tag, Reference reference);
}
