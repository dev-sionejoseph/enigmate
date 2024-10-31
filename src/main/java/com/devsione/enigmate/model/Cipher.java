package com.devsione.enigmate.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ciphers")
public class Cipher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String key;

    @ManyToOne
    @JoinColumn(name = "codemaker", nullable = false)
    private User codemaker;

    @ManyToMany
    @JoinTable(
            name = "permissions",
            joinColumns = @JoinColumn(name = "cipher_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> codebreakers;

    // CONSTRUCTORS
    public Cipher(){

    }

    public Cipher(String name, String key, User codemaker) {
        this.name = name;
        this.key = key;
        this.codemaker = codemaker;
    }

    // GETTERS AND SETTERS

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public User getCodemaker() {
        return codemaker;
    }

    public void setCodemaker(User codemaker) {
        this.codemaker = codemaker;
    }

    public Set<User> getCodebreakers() {
        return codebreakers;
    }

    public void setCodebreakers(Set<User> codebreakers) {
        this.codebreakers = codebreakers;
    }
}
