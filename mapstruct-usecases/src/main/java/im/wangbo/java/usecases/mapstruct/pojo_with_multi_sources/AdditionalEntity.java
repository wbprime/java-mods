package im.wangbo.java.usecases.mapstruct.pojo_with_multi_sources;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-16 by Elvis Wang
 */
public class AdditionalEntity {
    private OffsetDateTime updatedAt;
    private String updatedBy;
    private String content;

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AdditionalEntity that = (AdditionalEntity) o;
        return Objects.equals(updatedAt, that.updatedAt) &&
            Objects.equals(updatedBy, that.updatedBy) &&
            Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(updatedAt, updatedBy, content);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AdditionalEntity.class.getSimpleName() + "[", "]")
            .add("updatedAt=" + updatedAt)
            .add("updateBy='" + updatedBy + "'")
            .add("content='" + content + "'")
            .toString();
    }
}
