package io.emiliebarre.vinyl.api.dtos;

public record CustomerView(
        Long id,
        String name,
        String email,
        String address
) {
}
