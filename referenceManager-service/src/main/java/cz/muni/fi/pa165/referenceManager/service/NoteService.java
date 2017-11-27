package cz.muni.fi.pa165.referenceManager.service;

import cz.muni.fi.pa165.referenceManager.entity.Note;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Interface representing NoteService.
 *
 * @author Lenka Smitalova
 */
@Service
public interface NoteService {

    /**
     * Add note to database.
     * @param note note to be inserted into to the database.
     * @throws IllegalArgumentException if given note is null
     */
    void create(Note note);

    /**
     * Updates note's text to newText.
     * @param noteId note's id
     * @param newText new text to set
     */
    void changeNoteText(Long noteId, String newText);

    /**
     * Remove note from database.
     * @param noteId note's id
     */
    void remove(Long noteId);

    /**
     * Find note by its ID.
     * @param noteId note's id to be found
     * @return note with given id if found, null otherwise
     */
    Note findById(Long noteId);

    /**
     * Returns every stored note in database.
     * @return every stored note in database
     */
    Collection<Note> findAllNotes();
}
