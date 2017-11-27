package cz.muni.fi.pa165.referenceManager.service;

import cz.muni.fi.pa165.referenceManager.dao.ReferenceDao;
import cz.muni.fi.pa165.referenceManager.entity.Note;
import cz.muni.fi.pa165.referenceManager.entity.Reference;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ReferenceServiceTest {

    @Mock
    ReferenceDao referenceDao;

    @InjectMocks
    ReferenceServiceImpl referenceService;

    private Reference reference;
    private Reference reference2;
    private List<Reference> references;
    private Note note;

    @Mock
    private Reference referenceMock;

    @Before
    public void beforeTest(){
        MockitoAnnotations.initMocks(this);
        reference = new Reference(1l);
        reference.setTitle("Test reference.");
        reference2 = new Reference(2l);
        reference2.setTitle("Test reference 2");

        note = new Note(3l);
        note.setText("Test note");

        Mockito.when(referenceDao.findById(reference.getId())).thenReturn(reference);
        Mockito.when(referenceDao.findById(reference2.getId())).thenReturn(reference2);

        references = Arrays.asList(reference,reference2);
        Mockito.when(referenceDao.findAll()).thenReturn(references);

    }

    @Test
    public void testCreateReference(){
        referenceService.createReference(reference);
        Mockito.verify(referenceDao, Mockito.times(1)).create(reference);
    }

    @Test
    public void testUpdateReference(){
        referenceService.updateReference(reference);
        Mockito.verify(referenceDao, Mockito.times(1)).update(reference);
    }

    @Test
    public void testRemoveReference(){
        referenceService.deleteReference(reference.getId());
        Mockito.verify(referenceDao, Mockito.times(1)).remove(reference);
    }

    @Test
    public void testFindById(){
        referenceService.findById(reference.getId());
        Mockito.verify(referenceDao, Mockito.times(1)).findById(reference.getId());
    }

    @Test
    public void testGetAllReferences(){
        Collection<Reference> allReferences = referenceService.getAllReferences();
        Assert.assertEquals(allReferences,references);
    }

    @Test
    public void testAddNote(){
        referenceService.addNote(referenceMock, note);
        Mockito.verify(referenceMock,Mockito.times(1)).addNote(note);
    }

    @Test
    public void testRemoveNote(){
        referenceService.removeNote(referenceMock, note);
        Mockito.verify(referenceMock, Mockito.times(1)).removeNote(note);
    }


}
