package cz.muni.fi.pa165.referenceManager.service.facade;

import cz.muni.fi.pa165.referenceManager.dto.NoteDTO;
import cz.muni.fi.pa165.referenceManager.entity.Note;
import cz.muni.fi.pa165.referenceManager.facade.NoteFacade;
import cz.muni.fi.pa165.referenceManager.service.MappingService;
import cz.muni.fi.pa165.referenceManager.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Implementation of the NoteFacade interface.
 *
 * @author Lenka Smitalova
 */
@Service
@Transactional
public class NoteFacadeImpl implements NoteFacade {

    @Inject
    private NoteService noteService;

    @Autowired
    private MappingService mappingService;

    @Override
    public Long createNote(NoteDTO noteDTO) {
        Note note = mappingService.mapTo(noteDTO, Note.class);
        noteService.create(note);
        return note.getId();
    }

    @Override
    public void changeNoteText(NoteDTO noteDTO, String newText) {
        noteService.changeNoteText(noteDTO.getId(), newText);
    }

    @Override
    public void removeNote(Long noteId) {
        noteService.remove(noteId);
    }

    @Override
    public NoteDTO findById(NoteDTO noteDTO) {
        Note note = noteService.findById(noteDTO.getId());
        return (note == null) ? null : mappingService.mapTo(note, NoteDTO.class);
    }

    @Override
    public List<NoteDTO> findAllNotes() {
        return mappingService.mapTo(noteService.findAllNotes(), NoteDTO.class);
    }
}
