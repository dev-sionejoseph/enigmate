package com.devsione.enigmate.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private User receiver;
    
    @ManyToOne
    @JoinColumn(name = "cipher_id", nullable = false)
    private Cipher cipher;
    
    @Column(nullable = false)
    private LocalDateTime dateCreated;
    
    @Column(nullable = false)
    private String encodedMessage;
    
    //CONSTRUCTORS
    public Message(){
        
    }

    public Message(User sender, User receiver, Cipher cipher, LocalDateTime dateCreated, String encodedMessage) {
        this.sender = sender;
        this.receiver = receiver;
        this.cipher = cipher;
        this.dateCreated = dateCreated;
        this.encodedMessage = encodedMessage;
    }
    
    //GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Cipher getCipher() {
        return cipher;
    }

    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getEncodedMessage() {
        return encodedMessage;
    }

    public void setEncodedMessage(String encodedMessage) {
        this.encodedMessage = encodedMessage;
    }
}
