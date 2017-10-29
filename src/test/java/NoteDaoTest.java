import dao.NoteDao;
import entity.Note;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceApplicationContext.class)
public class NoteDaoTest {

    @Inject
    private NoteDao noteDao;

    @Test
    @Transactional
    @Rollback(true)
    public void createNoteTest(){
        Note note = new Note();
        note.setText("Test note");
        noteDao.create(note);
        List<Note> foundNotes = noteDao.findAll();
        Assert.assertEquals(1,foundNotes.size());
        Assert.assertEquals("Test note",foundNotes.get(0).getText());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void updateNoteTest(){
        Note note = new Note();
        note.setText("Original text");
        noteDao.create(note);
        note.setText("New text");
        noteDao.update(note);
        List<Note> foundNotes = noteDao.findAll();
        Assert.assertEquals("New text",foundNotes.get(0).getText());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void deleteNoteTest(){
        Note note = new Note();
        note.setText("Test note");
        noteDao.create(note);
        List<Note> foundNotes = noteDao.findAll();
        Assert.assertEquals(1,foundNotes.size());
        noteDao.remove(note);
        foundNotes = noteDao.findAll();
        Assert.assertEquals(0,foundNotes.size());
    }
}
