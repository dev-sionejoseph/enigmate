package com.devsione.enigmate.dto;

import jakarta.validation.constraints.NotNull;

public class CodebreakerDTO {

    @NotNull
    private String codebreaker;

    @NotNull
    private String cipherName;

    @NotNull
    private String codemaker;
   /* private String key;*/

    public CodebreakerDTO() {
    }

    public CodebreakerDTO(String codebreaker, String cipherName, String codemaker) {
        this.codebreaker = codebreaker;
        this.cipherName = cipherName;
        this.codemaker = codemaker;
    }

    public @NotNull String getCodebreaker() {
        return codebreaker;
    }

    public void setCodebreaker(@NotNull String codebreaker) {
        this.codebreaker = codebreaker;
    }

    public @NotNull String getCipherName() {
        return cipherName;
    }

    public void setCipherName(@NotNull String cipherName) {
        this.cipherName = cipherName;
    }

    public @NotNull String getCodemaker() {
        return codemaker;
    }

    public void setCodemaker(@NotNull String codemaker) {
        this.codemaker = codemaker;
    }
}
