package ssh8560.myproject.web.lostark.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillTripod {
    @JsonProperty("Tier")
    private Integer tier;

    @JsonProperty("Slot")
    private Integer slot;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Icon")
    private String icon;

    @JsonProperty("Level")
    private Integer level;

    @JsonProperty("IsSelected")
    private Boolean isSelected;

    @JsonProperty("Tooltip")
    private String tooltip;
}
