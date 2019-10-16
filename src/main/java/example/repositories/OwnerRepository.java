package example.repositories;

import example.domain.Owner;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    @Override
    List<Owner> findAll();

    Optional<Owner> findByName(String name);
}