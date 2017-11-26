package cz.muni.fi.pa165.referenceManager.dto;

import java.util.Set;

public class UserDTO {

    private Long id;
    private String email;
    private String name;
    private String passwordHash;
    private Set<TagDTO> tags;

    private Set<ReferenceDTO> references;

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

    public Set<TagDTO> getTags() {
        return tags;
    }

    public void setTags(Set<TagDTO> tags) {
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ReferenceDTO> getReferences() {
        return references;
    }

    public void setReferences(Set<ReferenceDTO> references) {
        this.references = references;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO)) return false;

        UserDTO userDTO = (UserDTO) o;

        if (!getId().equals(userDTO.getId())) return false;
        if (!getEmail().equals(userDTO.getEmail())) return false;
        if (getName() != null ? !getName().equals(userDTO.getName()) : userDTO.getName() != null) return false;
        if (!getPasswordHash().equals(userDTO.getPasswordHash())) return false;
        if (getTags() != null ? !getTags().equals(userDTO.getTags()) : userDTO.getTags() != null) return false;
        return getReferences() != null ? getReferences().equals(userDTO.getReferences()) : userDTO.getReferences() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPasswordHash() != null ? getPasswordHash().hashCode() : 0);
        result = 31 * result + (getTags() != null ? getTags().hashCode() : 0);
        result = 31 * result + (getReferences() != null ? getReferences().hashCode() : 0);
        return result;
    }

}
