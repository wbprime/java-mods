/*
 * This file is generated by jOOQ.
 */
package im.wangbo.java.usecases.generated.postgresql.tables.interfaces;


import javax.annotation.Generated;


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
public interface IBook {

    /**
     * Setter for <code>public.book.id</code>.
     */
    public void setId(Long value);

    /**
     * Getter for <code>public.book.id</code>.
     */
    public Long getId();

    /**
     * Setter for <code>public.book.author_id</code>.
     */
    public void setAuthorId(Long value);

    /**
     * Getter for <code>public.book.author_id</code>.
     */
    public Long getAuthorId();

    /**
     * Setter for <code>public.book.title</code>.
     */
    public void setTitle(String value);

    /**
     * Getter for <code>public.book.title</code>.
     */
    public String getTitle();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IBook
     */
    public void from(im.wangbo.java.usecases.generated.postgresql.tables.interfaces.IBook from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IBook
     */
    public <E extends im.wangbo.java.usecases.generated.postgresql.tables.interfaces.IBook> E into(E into);
}