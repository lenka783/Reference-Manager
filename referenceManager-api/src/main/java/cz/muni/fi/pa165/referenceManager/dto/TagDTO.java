package cz.muni.fi.pa165.referenceManager.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Lenka Smitalova
 */
public class TagDTO {

    private Long id;

    private String name;

    private Set<ReferenceDTO> references = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ReferenceDTO> getReferences() {
        return references;
    }

    public void setReferences(Set<ReferenceDTO> references) {
        this.references = references;
    }

    public void addReference(ReferenceDTO reference) {
        references.add(reference);
    }

    public void removeReference(ReferenceDTO reference) {
        references.remove(reference);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof TagDTO)) return false;

        TagDTO tag = (TagDTO) o;

        return Objects.equals(name, tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
