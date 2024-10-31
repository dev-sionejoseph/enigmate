package com.devsione.enigmate.model;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "codemaker")
    private Set<Cipher> createdCiphers;

    @ManyToMany(mappedBy = "codebreakers")
    private Set<Cipher> permittedCiphers;

    // constructors

    public User(){

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

    public void setCreatedCiphers(Set<Cipher> createdCiphers) {
        this.createdCiphers = createdCiphers;
    }

    public Set<Cipher> getPermittedCiphers() {
        return permittedCiphers;
    }

    public void setPermittedCiphers(Set<Cipher> permittedCiphers) {
        this.permittedCiphers = permittedCiphers;
    }
}
