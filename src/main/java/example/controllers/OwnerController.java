package example.controllers;

import example.domain.Owner;
import example.domain.OwnerWithPets;
import example.repositories.OwnerRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.validation.constraints.NotBlank;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Controller("/owners")
class OwnerController {
    private final OwnerRepository ownerRepository;

    OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Get("/")
    List<Owner> all() {
        return ownerRepository.findAll();
    }

    @Get("/{name}")
    Optional<OwnerWithPets> byName(@NotBlank String name) throws SQLException {
        return ownerRepository.findByName(name);
    }
}
