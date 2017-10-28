package dao;

import entity.Tag;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Andrej Staruch
 */

public class TagDaoImpl implements TagDao {
    @PersistenceContext
    EntityManager em;

    @Override
    public void create(Tag t) {
        em.persist(t);
    }

    @Override
    public void update(Tag t) {
        em.merge(t);
    }

    @Override
    public void remove(Tag t) {
        Tag managed = em.merge(t);
        em.remove(managed);
    }

    @Override
    public Tag findById(Long id) {
        return em.find(Tag.class, id);
    }

    @Override
    public List<Tag> findAll() {
        return em.createQuery("SELECT t FROM Tag t", Tag.class).getResultList();
    }
}
