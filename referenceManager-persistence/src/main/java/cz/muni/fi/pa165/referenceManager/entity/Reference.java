package cz.muni.fi.pa165.referenceManager.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author Lenka Šmitalová
 */
@Entity
@Table(name = "References_table")
public class Reference {

    @Id
    @Column(name = "REFERENCE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @NotEmpty
    @ElementCollection
    private List<String> authors = new ArrayList<String>();

    private String venue;

    @Pattern(regexp = "(\\d+(-\\d+)?)(,\\d+(-\\d+)?)*")
    private String pages;

    @OneToMany
    private Set<Note> notes = new HashSet<Note>();

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reference reference = (Reference) o;

        if (!title.equals(reference.title)) return false;
        if (!authors.equals(reference.authors)) return false;
        if (venue != null ? !venue.equals(reference.venue) : reference.venue != null) return false;
        return pages != null ? pages.equals(reference.pages) : reference.pages == null;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = title.hashCode();
        result = prime * result + authors.hashCode();
        result = prime * result + (venue != null ? venue.hashCode() : 0);
        result = prime * result + (pages != null ? pages.hashCode() : 0);
        return result;
    }
}
