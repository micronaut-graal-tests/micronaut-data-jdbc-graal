package example.domain;

import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.AutoPopulated;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;

import java.util.UUID;

@MappedEntity
public class Pet {

    @Id
    @AutoPopulated
    private UUID id;
    private String name;
    @Relation(value = Relation.Kind.MANY_TO_ONE)
    private Owner owner;
    private PetType type = PetType.DOG;

    @Creator
    public Pet(String name, @Nullable Owner owner) {
        this.name = name;
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public enum PetType {
        DOG,
        CAT
    }
}