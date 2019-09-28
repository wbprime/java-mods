package im.wangbo.java.usecases.autovalue.builder;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.time.OffsetDateTime;
import java.util.Collections;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


/**
 * TODO Detail goes here.
 * <p>
 * Created at 2019-09-26 by Elvis Wang
 */
class StudentDtoTest {

    @Test
    void testToJson() {
        final StudentDto dto = StudentDto.builder()
            .setName("name")
            .setLevel(Level.BAD)
            .setAddr("Addr sfahfs")
            .setBirthday(OffsetDateTime.now())
            .setScores(Collections.emptyMap())
            .setEmails(Collections.emptyList())
            .setAdditionalInt(1000)
            .setAdditionalList(ImmutableList.of("12", "345", "789"))
            .setAdditionalMap(ImmutableMap.of("k1", 345, "k2", 789))
            .build();

        final String str = JsonbBuilder.create(
            new JsonbConfig().withPropertyVisibilityStrategy(new AutoValueBasedPropertyVisibilityStrategy())
        ).toJson(dto, StudentDto.class);

        System.out.println(str);
    }

    @Disabled
    @Test
    void testFromJson() {
        final String json = "{\"additionalInt\":1000,\"additionalList\":[\"12\",\"345\",\"789\"],"
            + "\"additionalMap\":{\"k1\":345,\"k2\":789},\"addr\":\"Addr sfahfs\","
            + "\"birthday\":\"2019-09-26T15:50:32.204+08:00\","
            + "\"emails\":[],\"level\":\"BAD\",\"name\":\"name\",\"scores\":{}}";

        final StudentDto.Builder builder = JsonbBuilder.create()
            .fromJson(json, StudentDto.Builder.class);

        System.out.println(builder.build());
    }
}
