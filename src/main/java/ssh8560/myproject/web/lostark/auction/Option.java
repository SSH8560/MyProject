package ssh8560.myproject.web.lostark.auction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public
class Option {
    @JsonProperty("Type")
    private String type;

    @JsonProperty("OptionName")
    private String optionName;

    @JsonProperty("OptionNameTripod")
    private String optionNameTripod;

    @JsonProperty("Value")
    private Integer value;

    @JsonProperty("IsPenalty")
    private boolean isPenalty;

    @JsonProperty("ClassName")
    private String className;

}
