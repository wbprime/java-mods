package im.wangbo.java.micronaut.validation;

import io.micronaut.core.annotation.Introspected;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
@Introspected
class SimpleDto
    {
    @Max(1000)
    @Min(100)
    @NotNull
    private Integer val1;

    @NotBlank
    private String val2;

    @NotEmpty
    @Valid
    private List<@NotBlank String> val3;

    public Integer getVal1()
        {
        return val1;
        }

    public void setVal1(Integer val1)
        {
        this.val1 = val1;
        }

    public String getVal2()
        {
        return val2;
        }

    public void setVal2(String val2)
        {
        this.val2 = val2;
        }

    public List<String> getVal3()
        {
        return val3;
        }

    public void setVal3(List<String> val3)
        {
        this.val3 = val3;
        }

    @Override
    public String toString()
        {
        return "SimpleDto{" +
            "val1=" + val1 +
            ", val2='" + val2 + '\'' +
            ", val3=" + val3 +
            '}';
        }
    }
