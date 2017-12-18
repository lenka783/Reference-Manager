package cz.muni.fi.pa165.referenceManager.dto;

/**
 * @author Andrej Staruch
 *
 * DTO object user for Tag editation
 */
public class TagUpdateDTO extends TagDTO {
    private Long id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
