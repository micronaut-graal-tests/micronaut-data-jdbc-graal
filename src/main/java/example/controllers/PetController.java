package example.controllers;

import example.domain.NameDTO;
import example.domain.Pet;
import example.repositories.PetRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller("/pets")
class PetController {

    private final PetRepository petRepository;

    PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Get("/")
    List<NameDTO> all() {
        // Sort in memory because MSSQL Server doesn't support pageable
        return petRepository
                .list()
                .stream()
                .sorted(Comparator.comparing(NameDTO::getName))
                .collect(Collectors.toList());
    }

    @Get("/{name}")
    Optional<Pet> byName(String name) {
        return petRepository.findByName(name);
    }

}