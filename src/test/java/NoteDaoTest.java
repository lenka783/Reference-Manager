import dao.NoteDao;
import entity.Note;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceApplicationContext.class)
@Transactional
public class NoteDaoTest {

    @Inject
    private NoteDao noteDao;

    @PersistenceContext
    private EntityManager em;

    @Test
    public void testCreateNoteSuccess() {
        Note note = new Note();
        note.setText("Test note");
        noteDao.create(note);
        Assert.assertNotNull(note.getId());
        Note foundNote = em.find(Note.class,note.getId());
        Assert.assertTrue(note.equals(foundNote));
    }

    @Test
    public void testUpdateNoteSuccess() {
        Note note = new Note();
        note.setText("Original text");
        noteDao.create(note);
        note.setText("New text");
        noteDao.update(note);
        Note foundNote = em.find(Note.class,note.getId());
        Assert.assertEquals("New text", foundNote.getText());
    }

    @Test
    public void testDeleteNoteSuccess() {
        Note note = new Note();
        note.setText("Test note");
        noteDao.create(note);
        Note foundNote = em.find(Note.class,note.getId());
        Assert.assertTrue(foundNote.equals(note));
        noteDao.remove(note);
        foundNote = em.find(Note.class,note.getId());
        Assert.assertEquals(null, foundNote);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testDeleteNoteFail(){
        Note note = new Note();
        noteDao.remove(note);
    }
}
