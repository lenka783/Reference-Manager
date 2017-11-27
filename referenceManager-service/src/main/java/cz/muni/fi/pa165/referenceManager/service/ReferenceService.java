package cz.muni.fi.pa165.referenceManager.service;

import cz.muni.fi.pa165.referenceManager.entity.Note;
import cz.muni.fi.pa165.referenceManager.entity.Reference;

import java.util.List;

/**
 * Interface that specify service methods for access to Reference entity
 * @author Jan Bílek
 */
public interface ReferenceService {
    /**
     * Insert new reference into to database.
     * @param r reference to be inserted
     * @throws IllegalArgumentException if given reference is null
     */
    void createReference(Reference r);

    /**
     * Updates existing reference in database
     * @param r reference to update
     */
    void updateReference(Reference r);

    /**
     * Delete existing reference in database
     * @param id reference's id to be deleted
     */
    void deleteReference(Long id);

    /**
     * Creates mapping between reference and note
     * @param r reference to add note
     * @param note note to be added
     */
    void addNote(Reference r, Note note);

    /**
     * Remove mapping between reference and note
     * @param r reference having note
     * @param note note to be removed
     */
    void removeNote(Reference r, Note note);

    /**
     * Return all stored references in database
     * @return all stored references in database
     */
    List<Reference> getAllReferences();

    /**
     * Finds a reference by its id
     * @param id id of reference to find
     * @return reference with given id if found, null otherwise
     */
    Reference findById(Long id);
}
