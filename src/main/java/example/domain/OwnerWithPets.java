package example.domain;

import io.micronaut.core.annotation.Introspected;

import java.util.List;

@Introspected
public class OwnerWithPets extends Owner {
    private List<Pet> pets;

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
