package io.emiliebarre.vinyl.api.dtos;

public record CustomerUpdate(
        String firstname,
        String lastname,
        String email,
        String phone
) {
}
