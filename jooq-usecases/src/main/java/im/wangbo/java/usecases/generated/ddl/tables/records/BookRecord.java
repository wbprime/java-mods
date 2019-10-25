/*
 * This file is generated by jOOQ.
 */
package im.wangbo.java.usecases.generated.ddl.tables.records;


import im.wangbo.java.usecases.generated.ddl.tables.Book;
import im.wangbo.java.usecases.generated.ddl.tables.interfaces.IBook;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BookRecord extends UpdatableRecordImpl<BookRecord> implements Record3<Long, Long, String>, IBook {

    private static final long serialVersionUID = -2087310908;

    /**
     * Setter for <code>PUBLIC.BOOK.ID</code>.
     */
    @Override
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>PUBLIC.BOOK.ID</code>.
     */
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>PUBLIC.BOOK.AUTHOR_ID</code>.
     */
    @Override
    public void setAuthorId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>PUBLIC.BOOK.AUTHOR_ID</code>.
     */
    @Override
    public Long getAuthorId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>PUBLIC.BOOK.TITLE</code>.
     */
    @Override
    public void setTitle(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>PUBLIC.BOOK.TITLE</code>.
     */
    @Override
    public String getTitle() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, Long, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Long, Long, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Book.BOOK.ID;
    }

    @Override
    public Field<Long> field2() {
        return Book.BOOK.AUTHOR_ID;
    }

    @Override
    public Field<String> field3() {
        return Book.BOOK.TITLE;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getAuthorId();
    }

    @Override
    public String component3() {
        return getTitle();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getAuthorId();
    }

    @Override
    public String value3() {
        return getTitle();
    }

    @Override
    public BookRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public BookRecord value2(Long value) {
        setAuthorId(value);
        return this;
    }

    @Override
    public BookRecord value3(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public BookRecord values(Long value1, Long value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IBook from) {
        setId(from.getId());
        setAuthorId(from.getAuthorId());
        setTitle(from.getTitle());
    }

    @Override
    public <E extends IBook> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BookRecord
     */
    public BookRecord() {
        super(Book.BOOK);
    }

    /**
     * Create a detached, initialised BookRecord
     */
    public BookRecord(Long id, Long authorId, String title) {
        super(Book.BOOK);

        set(0, id);
        set(1, authorId);
        set(2, title);
    }
}