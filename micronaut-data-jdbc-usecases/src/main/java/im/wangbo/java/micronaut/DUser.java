package im.wangbo.java.micronaut;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

import java.time.OffsetDateTime;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
@MappedEntity(value = "t_user")
class DUser
    {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private OffsetDateTime birthday;

    private long createdAt;
    private long lastUpdatedAt;

    public Long getId()
        {
        return id;
        }

    public void setId(Long id)
        {
        this.id = id;
        }

    public String getName()
        {
        return name;
        }

    public void setName(String name)
        {
        this.name = name;
        }

    public OffsetDateTime getBirthday()
        {
        return birthday;
        }

    public void setBirthday(OffsetDateTime birthday)
        {
        this.birthday = birthday;
        }

    public long getCreatedAt()
        {
        return createdAt;
        }

    public void setCreatedAt(long createdAt)
        {
        this.createdAt = createdAt;
        }

    public long getLastUpdatedAt()
        {
        return lastUpdatedAt;
        }

    public void setLastUpdatedAt(long lastUpdatedAt)
        {
        this.lastUpdatedAt = lastUpdatedAt;
        }

    @Override
    public String toString()
        {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", birthday=" + birthday +
            ", createdAt=" + createdAt +
            ", lastUpdatedAt=" + lastUpdatedAt +
            '}';
        }
    }
