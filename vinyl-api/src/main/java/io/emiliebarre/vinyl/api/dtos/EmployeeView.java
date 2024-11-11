package io.emiliebarre.vinyl.api.dtos;

public record EmployeeView(
        Long id,
        String firstname,
        String lastname,
        String job,
        String identifier,
        String password,
        String manager
) {
}
