package cz.muni.fi.pa165.referenceManager.dto;

/**
 * @author Andrej Staruch
 *
 * DTO object used for Note editation
 */
public class NoteUpdateDTO extends NoteDTO {
    private Long id;

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    private String text;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
