/*
 * This file is generated by jOOQ.
 */
package im.wangbo.java.usecases.generated.ddl;


import im.wangbo.java.usecases.generated.ddl.tables.Author;
import im.wangbo.java.usecases.generated.ddl.tables.Book;
import im.wangbo.java.usecases.generated.ddl.tables.records.AuthorRecord;
import im.wangbo.java.usecases.generated.ddl.tables.records.BookRecord;

import javax.annotation.Generated;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>PUBLIC</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<AuthorRecord, Long> IDENTITY_AUTHOR = Identities0.IDENTITY_AUTHOR;
    public static final Identity<BookRecord, Long> IDENTITY_BOOK = Identities0.IDENTITY_BOOK;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AuthorRecord> CONSTRAINT_7 = UniqueKeys0.CONSTRAINT_7;
    public static final UniqueKey<BookRecord> CONSTRAINT_1 = UniqueKeys0.CONSTRAINT_1;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<AuthorRecord, Long> IDENTITY_AUTHOR = Internal.createIdentity(Author.AUTHOR, Author.AUTHOR.ID);
        public static Identity<BookRecord, Long> IDENTITY_BOOK = Internal.createIdentity(Book.BOOK, Book.BOOK.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<AuthorRecord> CONSTRAINT_7 = Internal.createUniqueKey(Author.AUTHOR, "CONSTRAINT_7", Author.AUTHOR.ID);
        public static final UniqueKey<BookRecord> CONSTRAINT_1 = Internal.createUniqueKey(Book.BOOK, "CONSTRAINT_1", Book.BOOK.ID);
    }
}
