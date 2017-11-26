package cz.muni.fi.pa165.referenceManager.service;

import cz.muni.fi.pa165.referenceManager.entity.Note;
import cz.muni.fi.pa165.referenceManager.entity.Reference;

import java.util.List;

/**
 * @author Jan Bílek
 */
public interface ReferenceService {
    void createReference(Reference r);

    void updateReference(Reference r);

    void deleteReference(Long id);

    void addNote(Reference r, Note note);

    void removeNote(Reference r, Note note);

    List<Reference> getAllReferences();

    Reference findById(Long id);
}
