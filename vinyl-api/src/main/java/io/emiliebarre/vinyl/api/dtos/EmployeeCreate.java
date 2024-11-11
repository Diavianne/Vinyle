package io.emiliebarre.vinyl.api.dtos;

public record EmployeeCreate(
        String firstname,
        String lastname,
        String job,
        String identifier,
        String password,
        String manager
) {
}
