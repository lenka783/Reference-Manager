package dao;

import entity.Note;

import java.util.List;

public interface NoteDao {

    void create(Note note);

    void update(Note note);

    void remove(Note note);

    Note findById(Long id);

    List<Note> findAll();
}
