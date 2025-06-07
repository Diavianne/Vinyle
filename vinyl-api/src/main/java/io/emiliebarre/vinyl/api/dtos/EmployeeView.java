package io.emiliebarre.vinyl.api.dtos;

public record EmployeeView(
        Long id,
        String firstname,
        String lastname,
        String email,
        String password
) {
}
