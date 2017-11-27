package cz.muni.fi.pa165.referenceManager.service;

import cz.muni.fi.pa165.referenceManager.dao.TagDao;
import cz.muni.fi.pa165.referenceManager.entity.Reference;
import cz.muni.fi.pa165.referenceManager.entity.Tag;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Set;

/**
 * Implementation of TagService interface.
 *
 * @author Lenka Smitalova
 */
@Service
public class TagServiceImpl implements TagService {
    @Inject
    private TagDao tagDao;

    @Override
    public void create(Tag tag) {
        tagDao.create(tag);
    }

    @Override
    public void updateTagName(Long tagId, String newName) {
        Tag tag = tagDao.findById(tagId);
        tag.setName(newName);
        tagDao.update(tag);
    }

    @Override
    public void remove(Long tagId) {
        Tag tag = findById(tagId);
        tagDao.remove(tag);
    }

    @Override
    public Tag findById(Long tagId) {
        return tagDao.findById(tagId);
    }

    @Override
    public Collection<Tag> findAllTags() {
        return tagDao.findAll();
    }

    @Override
    public void addReference(Tag tag, Reference reference) {
        Set<Reference> references = tag.getReferences();
        references.add(reference);
        tag.setReferences(references);
        tagDao.update(tag);
    }

    @Override
    public void removeReference(Tag tag, Reference reference) {
        Set<Reference> references = tag.getReferences();
        references.remove(reference);
        tag.setReferences(references);
        tagDao.update(tag);
    }
}
