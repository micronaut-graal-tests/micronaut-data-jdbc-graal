package example.repositories;

import example.domain.NameDTO;
import example.domain.Owner;
import example.domain.Pet;
import static example.domain.tables.Pet.PET;
import org.jooq.DSLContext;
import org.jooq.Record;

import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class PetRepository {
    private final DSLContext context;

    public PetRepository(DSLContext context) {
        this.context = context;
    }

    public List<NameDTO> list() {
        return context.select(PET.NAME).from(PET).fetchInto(NameDTO.class);
    }

    public Optional<Pet> findByName(String name) {
        Record record = context.select(PET.asterisk(), PET.owner().asterisk())
                .from(PET)
                .where(PET.NAME.eq(name))
                .fetchAny();

        if (record == null) {
            return Optional.empty();
        }

        Owner owner = new Owner();
        owner.setId(record.get(PET.owner().ID));
        owner.setName(record.get(PET.owner().NAME));
        owner.setAge(record.get(PET.owner().AGE));

        Pet pet = new Pet();
        pet.setId(record.get(PET.ID));
        pet.setName(record.get(PET.NAME));
        pet.setOwner(owner);

        return Optional.of(pet);
    }
}
