package io.emiliebarre.vinyl.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record Authentication(@NotBlank String email, @NotBlank String password) {
    @Override
    public String toString() {
        return "Authentication [email=" + email + ", password= [PROTECTED]]";
    }
}
