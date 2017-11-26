package cz.muni.fi.pa165.referenceManager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Class representing a Note cz.muni.fi.pa165.referenceManager.entity
 * This class is used for adding an extra note to references.
 * @author Andrej Staruch
 */

@Entity
@Table(name = "Notes")
public class Note {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String text;

    public Note() {
    }

    public Note(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
        if (object == null || !(object instanceof Note)) {
            return false;
        }
        Note note = (Note) object;
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
