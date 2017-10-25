package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Class representing a Note entity
 * This class is used for adding an extra note to references. 
 * @author Andrej Staruch
 */

@Entity
@Table(name = "Notes")
public class Note {
    @Id
    @GeneratedValue
    private Long id;
    
    private String text;

    private User creator;
    
    @OneToMany(mappedBy = "references")
    private Reference reference;
    
    public Long getId() {
        return id;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public User getCreator() {
        return creator;
    }
    
    public void setCreator(User creator) {
        this.creator = creator;
    }
    
    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null | !(object instanceof Note)) {
            return false;
        }
        Note note = (Note) object;
        return text.equals(note.getText()) && creator == note.getCreator();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (text != null ? text.hashCode() : 0);
        result = prime * result + creator.hashCode();
        return result;
    }
    
}
