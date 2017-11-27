package cz.muni.fi.pa165.referenceManager.dto;

/**
 * @author Lenka Smitalova
 */
public class NoteDTO {
    private Long id;

    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || !(object instanceof NoteDTO)) {
            return false;
        }
        NoteDTO note = (NoteDTO) object;
        return text.equals(note.getText());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
