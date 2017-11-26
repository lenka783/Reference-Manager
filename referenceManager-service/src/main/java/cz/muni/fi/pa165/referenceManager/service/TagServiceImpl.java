package cz.muni.fi.pa165.referenceManager.service;

import cz.muni.fi.pa165.referenceManager.dao.TagDao;
import cz.muni.fi.pa165.referenceManager.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author Lenka Smitalova
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagDao tagDao;

    @Override
    public void create(Tag tag) {
        tagDao.create(tag);
    }

    @Override
    public void update(Tag tag) {
        tagDao.update(tag);
    }

    @Override
    public void remove(Tag tag) {
        tagDao.remove(tag);
    }

    @Override
    public Tag getTagById(Long id) {
        return getTagById(id);
    }

    @Override
    public Collection<Tag> getAllTags() {
        return getAllTags();
    }
}
