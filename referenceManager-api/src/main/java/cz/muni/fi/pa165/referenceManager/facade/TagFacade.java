package cz.muni.fi.pa165.referenceManager.facade;

import cz.muni.fi.pa165.referenceManager.dto.TagDTO;

import java.util.List;

/**
 * @author Lenka Smitalova
 */
public interface TagFacade {

    void createTag(TagDTO tag);

    void updateTagName(Long tagId, String newName);

    void removeTag(TagDTO tag);

    TagDTO getTagById(Long id);

    List<TagDTO> getAllTags();

    void addReference(Long tagId, Long referenceId);

    void removeReference(Long tagId, Long referenceId);
}
