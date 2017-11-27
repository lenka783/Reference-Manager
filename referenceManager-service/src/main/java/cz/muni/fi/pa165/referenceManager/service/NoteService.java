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

    void create(Note note);

    void changeNoteText(Long noteId, String newText);

    void remove(Long noteId);

    Note findById(Long noteId);

    Collection<Note> findAllNotes();
}