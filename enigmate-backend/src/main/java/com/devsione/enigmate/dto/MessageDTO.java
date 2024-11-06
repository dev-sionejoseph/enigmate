package com.devsione.enigmate.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class MessageDTO {
    private Long messageId;

    @NotNull
    private String sender;

    @NotNull
    private String receiver;

    @NotNull
    private String cipher;

    @NotNull
    private String rawMessage;

    private LocalDateTime time;

    public MessageDTO(){

    }

    public MessageDTO(String sender, String receiver, String cipher, String rawMessage) {
        this.sender = sender;
        this.receiver = receiver;
        this.cipher = cipher;
        this.rawMessage = rawMessage;
    }

    public MessageDTO(Long messageId, String sender, String receiver, String cipher, String rawMessage, LocalDateTime time) {
        this.messageId = messageId;
        this.sender = sender;
        this.receiver = receiver;
        this.cipher = cipher;
        this.rawMessage = rawMessage;
        this.time = time;
    }

    public @NotNull String getSender() {
        return sender;
    }

    public void setSender(@NotNull String sender) {
        this.sender = sender;
    }

    public @NotNull String getReceiver() {
        return receiver;
    }

    public void setReceiver(@NotNull String receiver) {
        this.receiver = receiver;
    }

    public @NotNull String getCipher() {
        return cipher;
    }

    public void setCipher(@NotNull String cipher) {
        this.cipher = cipher;
    }

    public @NotNull String getRawMessage() {
        return rawMessage;
    }

    public void setRawMessage(@NotNull String rawMessage) {
        this.rawMessage = rawMessage;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
