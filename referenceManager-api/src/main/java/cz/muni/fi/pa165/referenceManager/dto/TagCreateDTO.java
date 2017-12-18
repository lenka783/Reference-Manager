package cz.muni.fi.pa165.referenceManager.dto;

import java.util.Objects;
/**
 * @author Andrej Staruch
 *
 * DTO object used for creating tag
 */
public class TagCreateDTO {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof  TagCreateDTO)) return false;
        TagCreateDTO that = (TagCreateDTO) obj;
        return Objects.equals(name, that.name);
    }
}
