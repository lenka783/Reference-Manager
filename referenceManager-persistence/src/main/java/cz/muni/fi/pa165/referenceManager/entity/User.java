package cz.muni.fi.pa165.referenceManager.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
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

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    private String name;

    @Column(nullable = false)
    private String passwordHash;

    @OneToMany
    private Set<Tag> tags = new HashSet<>();

    @OneToMany
    private Set<Reference> references = new HashSet<>();

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

}
