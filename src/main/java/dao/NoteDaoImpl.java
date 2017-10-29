package dao;

import entity.Note;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Lenka Šmitalová
 */
public class NoteDaoImpl implements NoteDao {
    @PersistenceContext
    EntityManager em;

    @Override
    public void create(Note note) {
        em.persist(note);
    }

    @Override
    public void update(Note note) {
        em.merge(note);
    }

    @Override
    public void remove(Note note) {
        Note managed = em.merge(note);
        em.detach(managed);
    }

    @Override
    public Note findById(Long id) {
        return em.find(Note.class, id);
    }

    @Override
    public List<Note> findAll() {
        return em.createQuery("select n from Note n", Note.class).getResultList();
    }
}
