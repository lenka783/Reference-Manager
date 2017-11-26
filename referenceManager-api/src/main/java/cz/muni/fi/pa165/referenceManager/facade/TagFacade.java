package cz.muni.fi.pa165.referenceManager.facade;

import cz.muni.fi.pa165.referenceManager.dto.TagDTO;

import java.util.List;

/**
 * @author Lenka Smitalova
 */
public interface TagFacade {

    Long createTag(TagDTO tag);

    void updateTagName(TagDTO tagDTO, String newName);

    void removeTag(Long tagId);

    TagDTO findById(TagDTO tagDTO);

    List<TagDTO> findAllTags();

    void addReference(Long tagId, Long referenceId);

    void removeReference(Long tagId, Long referenceId);
}
