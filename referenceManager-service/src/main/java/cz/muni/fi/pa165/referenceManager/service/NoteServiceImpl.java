package cz.muni.fi.pa165.referenceManager.service;

import cz.muni.fi.pa165.referenceManager.dao.NoteDao;
import cz.muni.fi.pa165.referenceManager.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author Lenka Smitalova
 */
@Service
public class NoteServiceImpl implements NoteService{
    @Autowired
    private NoteDao noteDao;

    @Override
    public void create(Note note) {
        noteDao.create(note);
    }

    @Override
    public void changeNoteText(Note note, String newText) {
        note.setText(newText);
        noteDao.update(note);
    }

    @Override
    public void remove(Note note) {
        noteDao.remove(note);
    }

    @Override
    public Note getNoteById(Long id) {
        return noteDao.findById(id);
    }

    @Override
    public Collection<Note> getAllNotes() {
        return noteDao.findAll();
    }
}
