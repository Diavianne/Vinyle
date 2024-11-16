package io.emiliebarre.vinyl.api.dtos;

public record CustomerCreate(
        String firstname,
        String lastname,
        String email,
        String phone
) {
}
