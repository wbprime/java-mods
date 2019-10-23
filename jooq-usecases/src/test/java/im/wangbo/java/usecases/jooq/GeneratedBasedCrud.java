package im.wangbo.java.usecases.jooq;

import im.wangbo.java.usecases.generated.postgresql.Tables;
import im.wangbo.java.usecases.generated.postgresql.tables.records.AuthorRecord;
import java.time.LocalDate;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.Test;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-23 by Elvis Wang
 */
class GeneratedBasedCrud {

    @Test
    void test_crud() {
        final DSLContext dsl = DSL.using(SQLDialect.POSTGRES); // Only for show case

        // READ
        AuthorRecord fetched =
            dsl.fetchOne(Tables.AUTHOR, Tables.AUTHOR.ID.eq(1993L));
        if (null == fetched) {
            fetched = dsl.newRecord(Tables.AUTHOR);

            fetched.setId(1993L);
            fetched.setFirstName("Elvis");
            fetched.setLastName("Wang");
        }

        fetched.setDateOfBirth(LocalDate.of(1993, 5, 25));
        fetched.setYearOfBirth(1993L);

        // CREATE on not-existed, otherwise UPDATE
        fetched.store();

        // DELETE
        fetched.delete();
    }
}
