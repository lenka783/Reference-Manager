package cz.muni.fi.pa165.referenceManager.service.facade;

import cz.muni.fi.pa165.referenceManager.dto.TagDTO;
import cz.muni.fi.pa165.referenceManager.facade.TagFacade;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Lenka Smitalova
 */
@Service
@Transactional
public class TagFacadeImpl implements TagFacade {
    @Override
    public void createTag(TagDTO tagDTO) {

    }

    @Override
    public void updateTagName(Long aLong, String s) {

    }

    @Override
    public void removeTag(TagDTO tagDTO) {

    }

    @Override
    public TagDTO getTagById(Long aLong) {
        return null;
    }

    @Override
    public List<TagDTO> getAllTags() {
        return null;
    }

    @Override
    public void addReference(Long aLong, Long aLong1) {

    }

    @Override
    public void removeReference(Long aLong, Long aLong1) {

    }
}
