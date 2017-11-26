package cz.muni.fi.pa165.referenceManager.facade;

import cz.muni.fi.pa165.referenceManager.dto.NoteDTO;

import java.util.List;

/**
 * @author Lenka Smitalova
 */
public interface NoteFacade {
    void createNote(NoteDTO note);

    void changeNoteText(NoteDTO noteDTO, String newText);

    void removeNote(NoteDTO noteDTO);

    NoteDTO getNoteById(Long id);

    List<NoteDTO> getAllNotes();
}
