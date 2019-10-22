/*
 * This file is generated by jOOQ.
 */
package im.wangbo.java.usecases.generated.ddl;


import im.wangbo.java.usecases.generated.ddl.tables.Author;
import im.wangbo.java.usecases.generated.ddl.tables.Book;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>PUBLIC</code> schema.
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

    public static final Index PRIMARY_KEY_7 = Indexes0.PRIMARY_KEY_7;
    public static final Index PRIMARY_KEY_1 = Indexes0.PRIMARY_KEY_1;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index PRIMARY_KEY_7 = Internal.createIndex("PRIMARY_KEY_7", Author.AUTHOR, new OrderField[] { Author.AUTHOR.ID }, true);
        public static Index PRIMARY_KEY_1 = Internal.createIndex("PRIMARY_KEY_1", Book.BOOK, new OrderField[] { Book.BOOK.ID }, true);
    }
}
