package cz.muni.fi.pa165.referenceManager.service;

import cz.muni.fi.pa165.referenceManager.dao.TagDao;
import cz.muni.fi.pa165.referenceManager.entity.Tag;
import cz.muni.fi.pa165.referenceManager.config.ServiceConfiguration;
import org.junit.Assert;
import org.junit.Before;
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
 * Set of tests testing the implementation of the TagService
 *
 * @author Lenka Smitalova
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class TagServiceTest {

    @Mock
    private TagDao tagDao;

    @Autowired
    @InjectMocks
    private TagService tagService = new TagServiceImpl();

    private Tag tag1;
    private Tag tag2;

    @Before
    public void beforeTest() {
        MockitoAnnotations.initMocks(this);

        tag1 = new Tag(1l);
        tag2 = new Tag(2l);

        tag1.setName("This is tag1.");
        tag2.setName("This is tag2.");

        Mockito.when(tagDao.findById(1l)).thenReturn(tag1);
        Mockito.when(tagDao.findById(2l)).thenReturn(tag2);

        List<Tag> tags = Arrays.asList(tag1, tag2);
        Mockito.when(tagDao.findAll()).thenReturn(tags);

    }

    @Test
    public void testCreate() {
        Mockito.verify(tagDao, Mockito.times(0)).create(tag1);
        tagService.create(tag1);
        Mockito.verify(tagDao, Mockito.times(1)).create(tag1);
    }

    @Test
    public void testFindAll() {
        Collection<Tag> notes = tagService.findAllTags();
        Assert.assertEquals(2, notes.size());
    }
}
