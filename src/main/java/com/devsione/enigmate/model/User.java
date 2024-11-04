package com.devsione.enigmate.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 4, max = 12)
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    /*@JsonIgnore*/
    private String password;

    @OneToMany(mappedBy = "codemaker")
    @JsonManagedReference(value = "createdCiphers")
    private Set<Cipher> createdCiphers;

    @ManyToMany(mappedBy = "codebreakers")
    private Set<Cipher> permittedCiphers;

    @OneToMany(mappedBy = "sender")
    @JsonManagedReference(value = "inbox")
    private Set<Message> inbox;

    @OneToMany(mappedBy = "receiver")
    @JsonManagedReference(value = "outbox")
    private Set<Message> outbox;


// constructors

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    protected void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Cipher> getCreatedCiphers() {
        return createdCiphers;
    }

    public void setCreatedCiphers(Cipher createdCipher) {
        createdCiphers.add(createdCipher);
    }

    public Set<Cipher> getPermittedCiphers() {
        return permittedCiphers;
    }

    public void setPermittedCiphers(Set<Cipher> permittedCiphers) {
        this.permittedCiphers = permittedCiphers;
    }

    public Set<Message> getInbox() {
        return inbox;
    }

    public void setInbox(Set<Message> inbox) {
        this.inbox = inbox;
    }

    public Set<Message> getOutbox() {
        return outbox;
    }

    public void setOutbox(Set<Message> outbox) {
        this.outbox = outbox;
    }
}
