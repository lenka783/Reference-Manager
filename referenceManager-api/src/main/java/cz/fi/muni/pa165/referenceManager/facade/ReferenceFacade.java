package cz.fi.muni.pa165.referenceManager.facade;

import cz.fi.muni.pa165.referenceManager.dto.NoteDTO;
import cz.fi.muni.pa165.referenceManager.dto.ReferenceDTO;

import java.util.List;

public interface ReferenceFacade {
    void createReference(ReferenceDTO r);
    void updateReference(ReferenceDTO r);
    void deleteReference(Long id);
    List<ReferenceDTO> getAllReferences();
    ReferenceDTO getReferenceById(Long id);
    void addNote(Long referenceId, NoteDTO note);
    void removeNote(Long referenceId, NoteDTO note);
}
