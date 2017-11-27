package cz.muni.fi.pa165.referenceManager.facade;

import cz.muni.fi.pa165.referenceManager.dto.ReferenceDTO;
import cz.muni.fi.pa165.referenceManager.dto.TagDTO;

import java.io.File;
import java.util.List;

public interface ImportExportFacade {
    List<ReferenceDTO> importReferences(Long userId, File file, TagDTO tagDTO);
    File exportReferences(Long tagId);
}
