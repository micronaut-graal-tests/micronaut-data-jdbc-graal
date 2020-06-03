package example.domain;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class PetWithOwner extends Pet {
    private Owner owner;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
