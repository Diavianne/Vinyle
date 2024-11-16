package io.emiliebarre.vinyl.api.dtos;

public record CustomerView(
        Long id,
        String firstname,
        String lastname,
        String email,
        String phone
) {
}
