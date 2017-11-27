package cz.muni.fi.pa165.referenceManager.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Jan Bílek
 * @since 2017-10-22
 **/

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    @Email
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String passwordHash;

    @OneToMany
    private Set<Tag> tags = new HashSet<>();

    @ManyToMany
    private Set<Tag> sharedTags = new HashSet<>();

    @ManyToMany
    private Set<Reference> references = new HashSet<>();

    public User() {}

    public User(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void addReference(Reference reference){
        references.add(reference);
    }

    public void removeReference(Reference reference){
        references.remove(reference);
    }

    public void addTag(Tag tag){
        tags.add(tag);
    }

    public void removeTag(Tag tag){
        tags.remove(tag);
    }



    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || !(object instanceof User)) {
            return false;
        }
        User user = (User) object;
        return Objects.equals(email, user.getEmail());
    }

    @Override
    public int hashCode() {
        final int primeNumber = 17;
        int resultHash = 1;
        resultHash = primeNumber * resultHash + email.hashCode();
        resultHash = primeNumber * resultHash + (name == null ? 0 : name.hashCode());
        return resultHash;
    }

    public Set<Tag> getSharedTags() {
        return sharedTags;
    }

    public void setSharedTags(Set<Tag> sharedTags) {
        this.sharedTags = sharedTags;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }


}
