/*
 * This file is generated by jOOQ.
 */
package im.wangbo.java.usecases.generated.postgresql.tables.pojos;


import im.wangbo.java.usecases.generated.postgresql.tables.interfaces.IAuthor;

import java.time.LocalDate;

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
public class Author implements IAuthor {

    private Long      id;
    private String    firstName;
    private String    lastName;
    private LocalDate dateOfBirth;
    private Long      yearOfBirth;

    public Author() {}

    public Author(IAuthor value) {
        this.id = value.getId();
        this.firstName = value.getFirstName();
        this.lastName = value.getLastName();
        this.dateOfBirth = value.getDateOfBirth();
        this.yearOfBirth = value.getYearOfBirth();
    }

    public Author(
        Long      id,
        String    firstName,
        String    lastName,
        LocalDate dateOfBirth,
        Long      yearOfBirth
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public Long getYearOfBirth() {
        return this.yearOfBirth;
    }

    @Override
    public void setYearOfBirth(Long yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Author other = (Author) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        }
        else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        }
        else if (!lastName.equals(other.lastName))
            return false;
        if (dateOfBirth == null) {
            if (other.dateOfBirth != null)
                return false;
        }
        else if (!dateOfBirth.equals(other.dateOfBirth))
            return false;
        if (yearOfBirth == null) {
            if (other.yearOfBirth != null)
                return false;
        }
        else if (!yearOfBirth.equals(other.yearOfBirth))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
        result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
        result = prime * result + ((this.dateOfBirth == null) ? 0 : this.dateOfBirth.hashCode());
        result = prime * result + ((this.yearOfBirth == null) ? 0 : this.yearOfBirth.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Author (");

        sb.append(id);
        sb.append(", ").append(firstName);
        sb.append(", ").append(lastName);
        sb.append(", ").append(dateOfBirth);
        sb.append(", ").append(yearOfBirth);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IAuthor from) {
        setId(from.getId());
        setFirstName(from.getFirstName());
        setLastName(from.getLastName());
        setDateOfBirth(from.getDateOfBirth());
        setYearOfBirth(from.getYearOfBirth());
    }

    @Override
    public <E extends IAuthor> E into(E into) {
        into.from(this);
        return into;
    }
}
