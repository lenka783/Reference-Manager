package dao;

import entity.Note;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Lenka Šmitalová
 */
@Repository
@Transactional
public class NoteDaoImpl implements NoteDao {

    @PersistenceContext
    private EntityManager em;

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
