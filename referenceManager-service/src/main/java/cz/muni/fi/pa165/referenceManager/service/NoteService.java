package cz.muni.fi.pa165.referenceManager.service;

import cz.muni.fi.pa165.referenceManager.entity.Note;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author Lenka Smitalova
 */
@Service
public interface NoteService {

    void create(Note note);

    void changeNoteText(Note note, String newText);

    void remove(Note note);

    Note getNoteById(Long id);

    Collection<Note> getAllNotes();
}
