import dao.NoteDao;
import dao.NoteDaoImpl;
import entity.Note;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = PersistenceApplicationContext.class)
public class NoteDaoTest {

    @Inject
    private NoteDao noteDao;

    @PersistenceContext
    private EntityManager em;

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Test
    public void createNoteTest(){
        Note note = new Note();
        note.setText("Test note");
        noteDao.create(note);
    }
}
