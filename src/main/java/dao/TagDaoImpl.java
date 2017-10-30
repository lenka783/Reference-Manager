package dao;

import entity.Tag;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Andrej Staruch
 */
@Repository
@Transactional
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
        Tag managed = em.find(Tag.class, t.getId());
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
