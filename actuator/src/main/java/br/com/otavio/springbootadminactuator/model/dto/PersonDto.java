package br.com.otavio.springbootadminactuator.model.dto;

import java.util.UUID;

public record PersonDto(
        UUID id,
        String name,
        String email
) {
}
