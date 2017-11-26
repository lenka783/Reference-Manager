package cz.fi.muni.pa165.referenceManager.dto;

import cz.muni.fi.pa165.referenceManager.entity.Note;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReferenceDTO {

    private Long id;

    @NotNull
    private String title;
    private List<String> authors = new ArrayList<>();
    private Set<Note> notes;
    private String venue;
    private Integer pagesStart;
    private Integer pagesEnd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getPagesStart() {
        return pagesStart;
    }

    public void setPagesStart(Integer pagesStart) {
        this.pagesStart = pagesStart;
    }

    public Integer getPagesEnd() {
        return pagesEnd;
    }

    public void setPagesEnd(Integer pagesEnd) {
        this.pagesEnd = pagesEnd;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

}
