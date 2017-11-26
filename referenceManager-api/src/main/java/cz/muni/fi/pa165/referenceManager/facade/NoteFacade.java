package cz.muni.fi.pa165.referenceManager.facade;

import cz.muni.fi.pa165.referenceManager.dto.NoteDTO;

import java.util.List;

/**
 * @author Lenka Smitalova
 */
public interface NoteFacade {
    Long createNote(NoteDTO note);

    void changeNoteText(NoteDTO noteDTO, String newText);

    void removeNote(Long noteId);

    NoteDTO findById(NoteDTO noteDTO);

    List<NoteDTO> findAllNotes();
}
