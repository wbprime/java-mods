/*
 * This file is generated by jOOQ.
 */
package im.wangbo.java.usecases.generated.postgresql;


import im.wangbo.java.usecases.generated.postgresql.tables.Author;
import im.wangbo.java.usecases.generated.postgresql.tables.Book;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index AUTHOR_PKEY = Indexes0.AUTHOR_PKEY;
    public static final Index BOOK_PKEY = Indexes0.BOOK_PKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index AUTHOR_PKEY = Internal.createIndex("author_pkey", Author.AUTHOR, new OrderField[] { Author.AUTHOR.ID }, true);
        public static Index BOOK_PKEY = Internal.createIndex("book_pkey", Book.BOOK, new OrderField[] { Book.BOOK.ID }, true);
    }
}
