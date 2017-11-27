package cz.muni.fi.pa165.referenceManager.service;

import cz.muni.fi.pa165.referenceManager.dao.NoteDao;
import cz.muni.fi.pa165.referenceManager.entity.Note;
import cz.muni.fi.pa165.referenceManager.config.ServiceConfiguration;
import jdk.nashorn.internal.runtime.ECMAException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.configuration.injection.MockInjection;
import org.mockito.runners.MockitoJUnitRunner;
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
@RunWith(MockitoJUnitRunner.class)
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

        Mockito.when(noteDao.findAll()).thenReturn(Arrays.asList(note1, note2));
    }

    @Test
    public void testCreate() {
        Mockito.verify(noteDao, Mockito.times(0)).create(note1);
        noteService.create(note1);
        Mockito.verify(noteDao, Mockito.times(1)).create(note1);
    }

    @Test
    public void testRemove(){
        noteService.remove(note1.getId());
        Mockito.verify(noteDao, Mockito.times(1)).remove(note1);
    }

    @Test
    public void testFindAll() {
        Collection<Note> notes = noteService.findAllNotes();
        Assert.assertEquals(2, notes.size());

        Assert.assertTrue(notes.contains(note1));
        Assert.assertTrue(notes.contains(note2));
    }

    @Test
    public void testFindById() {
        Note note = noteService.findById(2l);
        Assert.assertEquals("Found note should be the same as expected one.", note2, note);
    }

    @Test
    public void testChangeNoteText() {
        String newText = "New note text.";
        noteService.changeNoteText(1l, newText);

        Assert.assertEquals(newText, note1.getText());
        Assert.assertEquals("This is note2.", note2.getText());
    }
}
