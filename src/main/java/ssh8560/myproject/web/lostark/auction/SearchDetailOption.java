package ssh8560.myproject.web.lostark.auction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SearchDetailOption {
    @JsonProperty("FirstOption")
    private Integer firstOption;

    @JsonProperty("SecondOption")
    private Integer secondOption;

    @JsonProperty("MinValue")
    private Integer minValue;

    @JsonProperty("MaxValue")
    private Integer maxValue;
}
