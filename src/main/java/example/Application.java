package example;

import static example.domain.Tables.OWNER;
import static example.domain.Tables.PET;
import example.domain.tables.records.OwnerRecord;
import example.domain.tables.records.PetRecord;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.core.annotation.TypeHint;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;
import org.jooq.*;
import org.jooq.types.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.*;
import java.util.UUID;

@Singleton
@TypeHint(value = {
        PetRecord.class,
        OwnerRecord.class,
        LocalDate[].class,
        LocalDateTime[].class,
        LocalTime[].class,
        ZonedDateTime[].class,
        OffsetDateTime[].class,
        OffsetTime[].class,
        Instant[].class,
        Timestamp[].class,
        Date[].class,
        Time[].class,
        BigInteger[].class,
        BigDecimal[].class,
        UNumber[].class,
        UByte[].class,
        UInteger[].class,
        ULong[].class,
        Unsigned[].class,
        UShort[].class,
        Byte[].class,
        Integer[].class,
        Long[].class,
        Float[].class,
        Double[].class,
        String[].class,
        YearToMonth[].class,
        YearToSecond[].class,
        DayToSecond[].class,
        RowId[].class,
        Result[].class,
        Record[].class,
        JSON[].class,
        JSONB[].class,
        UUID[].class,
        byte[].class
})
public class Application {
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    private final DSLContext context;

    public Application(DSLContext context) {
        this.context = context;
    }

    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }

    @EventListener
    void init(StartupEvent event) {
        if (LOG.isInfoEnabled()) {
            LOG.info("Populating data");
        }

        OwnerRecord fred = context.newRecord(OWNER);
        fred.setName("Fred");
        fred.setAge(45);
        fred.store();

        OwnerRecord barney = context.newRecord(OWNER);
        barney.setName("Barney");
        barney.setAge(40);
        barney.store();

        PetRecord dino = context.newRecord(PET);
        dino.setName("Dino");
        dino.setOwnerId(fred.getId());
        dino.store();

        PetRecord babyPuss = context.newRecord(PET);
        babyPuss.setName("Baby Puss");
        babyPuss.setOwnerId(fred.getId());
        babyPuss.store();

        PetRecord hoppy = context.newRecord(PET);
        hoppy.setName("Hoppy");
        hoppy.setOwnerId(barney.getId());
        hoppy.store();
    }
}
