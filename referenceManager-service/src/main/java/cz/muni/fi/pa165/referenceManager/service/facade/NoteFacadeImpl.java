package cz.muni.fi.pa165.referenceManager.service.facade;

import cz.muni.fi.pa165.referenceManager.dao.NoteDao;
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
 * @author Lenka Smitalova
 */
@Service
@Transactional
public class NoteFacadeImpl implements NoteFacade {
    @Inject
    private NoteDao noteDao;

    @Inject
    private NoteService noteService;

    @Autowired
    private MappingService mappingService;

    @Override
    public void createNote(NoteDTO noteDTO) {
        Note note = mappingService.mapTo(noteDTO, Note.class);
        noteDao.create(note);
        noteDTO.setId(note.getId());
    }

    @Override
    public void changeNoteText(NoteDTO noteDTO, String newText) {
        noteService.changeNoteText(noteDao.findById(noteDTO.getId()), newText);
    }

    @Override
    public void removeNote(NoteDTO noteDTO) {
        noteService.remove(noteDao.findById(noteDTO.getId()));
    }

    @Override
    public NoteDTO getNoteById(Long noteId) {
        return mappingService.mapTo(noteDao.findById(noteId), NoteDTO.class);
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return mappingService.mapTo(noteDao.findAll(), NoteDTO.class);
    }
}
