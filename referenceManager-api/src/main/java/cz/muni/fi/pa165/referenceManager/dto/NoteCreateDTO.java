package cz.muni.fi.pa165.referenceManager.dto;

import java.util.Objects;

/**
 * @author Andrej Staruch
 */
public class NoteCreateDTO {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof  NoteCreateDTO)) return false;
        NoteCreateDTO that = (NoteCreateDTO) obj;
        return Objects.equals(text, that.text);
    }
}
