package example.repositories;

import example.domain.Owner;
import static example.domain.Tables.OWNER;
import org.jooq.DSLContext;

import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class OwnerRepository {
    private final DSLContext context;

    public OwnerRepository(DSLContext context) {
        this.context = context;
    }

    public List<Owner> findAll() {
        return context.selectFrom(OWNER).fetchInto(Owner.class);
    }

    public Optional<Owner> findByName(String name) {
        Owner owner = context.selectFrom(OWNER)
                .where(OWNER.NAME.eq(name))
                .fetchAnyInto(Owner.class);

        return Optional.ofNullable(owner);
    }
}
