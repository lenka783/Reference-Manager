package cz.muni.fi.pa165.referenceManager.service.facade;

import cz.muni.fi.pa165.referenceManager.dto.TagDTO;
import cz.muni.fi.pa165.referenceManager.entity.Tag;
import cz.muni.fi.pa165.referenceManager.facade.TagFacade;
import cz.muni.fi.pa165.referenceManager.service.MappingService;
import cz.muni.fi.pa165.referenceManager.service.ReferenceService;
import cz.muni.fi.pa165.referenceManager.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Lenka Smitalova
 */
@Service
@Transactional
public class TagFacadeImpl implements TagFacade {

    @Inject
    private TagService tagService;

    @Inject
    private ReferenceService referenceService;

    @Autowired
    private MappingService mappingService;

    @Override
    public Long createTag(TagDTO tagDTO) {
        Tag tag = mappingService.mapTo(tagDTO, Tag.class);
        Tag newTag = tagService.create(tag);
        return newTag.getId();
    }

    @Override
    public void updateTagName(TagDTO tagDTO, String newName) {
        tagService.updateTagName(tagDTO.getId(), newName);
    }

    @Override
    public void removeTag(Long tagId) {
        tagService.remove(new Tag(tagId));
    }

    @Override
    public TagDTO findById(TagDTO tagDTO) {
        Tag tag = tagService.findById(tagDTO.getId());
        return (tag == null) ? null : mappingService.mapTo(tag, TagDTO.class);
    }

    @Override
    public List<TagDTO> findAllTags() {
        return mappingService.mapTo(tagService.findAllTags(), TagDTO.class);
    }

    @Override
    public void addReference(Long tagId, Long referenceId) {
        tagService.addReference(
            tagService.findById(tagId),
            referenceService.findById(referenceId));
    }

    @Override
    public void removeReference(Long tagId, Long referenceId) {
        tagService.removeReference(
            tagService.findById(tagId),
            referenceService.findById(referenceId)
        );
    }
}
