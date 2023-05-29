package ssh8560.myproject.lostark;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tripod {
    @JsonProperty("Value")
    private int value;

    @JsonProperty("Text")
    private String text;

    @JsonProperty("IsGem")
    private boolean isGem;
}
