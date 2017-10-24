package entity;

import javax.persistence.*;
import java.util.HashSet;
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
    private String username;

    private String firstName;

    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @OneToMany
    private Set<Tag> tags = new HashSet<>();

    @OneToMany
    private Set<Reference> references = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return username == user.getUsername() &&
            email == user.getEmail();
    }

    @Override
    public int hashCode() {
        final int primeNumber = 17;
        int resultHash = 1;
        resultHash = primeNumber * resultHash + username.hashCode();
        resultHash = primeNumber * resultHash + email.hashCode();
        resultHash = primeNumber * resultHash + (lastName == null ? 0 : lastName.hashCode());
        return resultHash;
    }

}
