package cz.muni.fi.pa165.referenceManager.service;

import cz.muni.fi.pa165.referenceManager.dao.NoteDao;
import cz.muni.fi.pa165.referenceManager.entity.Note;
import cz.muni.fi.pa165.referenceManager.service.config.ServiceConfiguration;
import org.dozer.inject.Inject;
import org.hibernate.service.spi.ServiceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Set of tests testing the implementation of the NoteService
 *
 * @author Lenka Smitalova
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class NoteServiceTest {

    @Mock
    private NoteDao noteDao;

    @Autowired
    @InjectMocks
    private NoteService noteService = new NoteServiceImpl();

    private Note note1;
    private Note note2;

    @Before
    public void beforeTest() {
        MockitoAnnotations.initMocks(this);

        note1 = new Note(1l);
        note2 = new Note(2l);

        note1.setText("This is note1.");
        note2.setText("This is note2.");

        Mockito.when(noteDao.findById(1l)).thenReturn(note1);
        Mockito.when(noteDao.findById(2l)).thenReturn(note2);

        List<Note> notes = Arrays.asList(note1, note2);
        Mockito.when(noteDao.findAll()).thenReturn(notes);

    }

    @Test
    public void testCreate() {
        Mockito.verify(noteDao, Mockito.times(0)).create(note1);
        noteService.create(note1);
        Mockito.verify(noteDao, Mockito.times(1)).create(note1);
    }

    @Test
    public void testFindAll() {
        Collection<Note> notes = noteService.findAllNotes();
        Assert.assertEquals(2, notes.size());
    }
}
