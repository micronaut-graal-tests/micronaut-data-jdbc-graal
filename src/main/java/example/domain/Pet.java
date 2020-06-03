package example.domain;

import io.micronaut.core.annotation.Introspected;

import java.util.UUID;

@Introspected
public class Pet {
    private UUID id;
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
