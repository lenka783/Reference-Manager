package cz.muni.fi.pa165.referenceManager.service;

import cz.muni.fi.pa165.referenceManager.dao.NoteDao;
import cz.muni.fi.pa165.referenceManager.entity.Note;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Collection;

/**
 * @author Lenka Smitalova
 */
@Service
public class NoteServiceImpl implements NoteService{
    @Inject
    private NoteDao noteDao;

    @Override
    public void create(Note note) {
        noteDao.create(note);
    }

    @Override
    public void changeNoteText(Long noteId, String newText) {
        Note note = noteDao.findById(noteId);
        note.setText(newText);
        noteDao.update(note);
    }

    @Override
    public void remove(Note note) {
        noteDao.remove(note);
    }

    @Override
    public Note findById(Long id) {
        return noteDao.findById(id);
    }

    @Override
    public Collection<Note> findAllNotes() {
        return noteDao.findAll();
    }
}
