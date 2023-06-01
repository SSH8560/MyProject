package ssh8560.myproject.web.lostark.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ArmorySkill {
    @JsonProperty("Name")
    private String name;

    @JsonProperty("Icon")
    private String icon;

    @JsonProperty("Level")
    private Integer level;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("IsAwakening")
    private Boolean isAwakening;

    @JsonProperty("Tripods")
    private List<SkillTripod> tripods;

    @JsonProperty("Rune")
    private SkillRune rune;

    @JsonProperty("Tooltip")
    private String tooltip;
}
