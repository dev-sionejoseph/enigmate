package com.devsione.enigmate.dto;

import jakarta.validation.constraints.NotNull;

public class CipherDTO {

    @NotNull
    private String name;

    @NotNull
    private String key;

    @NotNull
    private Long userId;

    private String[] codebreakers;

    public CipherDTO(String name, String key, Long userId, String[] codebreakers) {
        this.name = name;
        this.key = key;
        this.userId = userId;
        this.codebreakers = codebreakers;
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public @NotNull String getKey() {
        return key;
    }

    public void setKey(@NotNull String key) {
        this.key = key;
    }

    public @NotNull Long getUserId() {
        return userId;
    }

    public void setUserId(@NotNull Long userId) {
        this.userId = userId;
    }

    public String[] getCodebreakers() {
        return codebreakers;
    }

    public void setCodebreakers(String[] codebreakers) {
        this.codebreakers = codebreakers;
    }
}
