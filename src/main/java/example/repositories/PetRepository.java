package example.repositories;

import example.domain.NameDTO;
import example.domain.PetWithOwner;
import static example.domain.Tables.OWNER;
import static example.domain.tables.Pet.PET;
import org.jooq.DSLContext;
import org.simpleflatmapper.jdbc.DynamicJdbcMapper;
import org.simpleflatmapper.jdbc.JdbcMapperFactory;

import javax.inject.Singleton;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class PetRepository {
    private final DSLContext context;
    private final DynamicJdbcMapper<PetWithOwner> mapper;

    public PetRepository(DSLContext context) {
        this.context = context;
        this.mapper = JdbcMapperFactory.newInstance()
                .addKeys("id", "owner_id")
                .newMapper(PetWithOwner.class);
    }

    public List<NameDTO> list() {
        return context.select(PET.NAME).from(PET).fetchInto(NameDTO.class);
    }

    public Optional<PetWithOwner> findByName(String name) throws SQLException {
        ResultSet rs = context.select(PET.ID, PET.NAME)
                .select(OWNER.ID.as("owner_id"), OWNER.NAME.as("owner_name"), OWNER.AGE.as("owner_age"))
                .from(PET)
                .join(OWNER)
                .on(PET.OWNER_ID.eq(OWNER.ID))
                .where(PET.NAME.eq(name))
                .fetchResultSet();

        List<PetWithOwner> list = mapper.stream(rs).collect(Collectors.toList());

        if (list.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(list.get(0));
        }
    }
}
