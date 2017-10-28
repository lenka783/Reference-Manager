package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Class representing a Tag entity, used to group multiple References together.
 * @author David Šarman
 */
@Entity
@Table(name = "Tags")
public class Tag {
    @Id
    @GeneratedValue
    @Column(name = "TAG_ID")
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany()
    @JoinTable(
        name = "Reference_Tag",
        joinColumns = { @JoinColumn(name = "TAG_ID") },
        inverseJoinColumns = { @JoinColumn(name = "REFERENCE_ID") }
    )
    private Set<Reference> references = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Tag)) return false;

        Tag tag = (Tag) o;

        return name.equals(tag.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
