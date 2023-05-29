package ssh8560.myproject.lostark;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SkillOption {
    @JsonProperty("Value")
    private int value;

    @JsonProperty("Class")
    private String ClassName;

    @JsonProperty("Text")
    private String text;

    @JsonProperty("IsSkillGroup")
    private boolean isSkillGroup;

    @JsonProperty("Tripods")
    private List<Tripod> tripods;
}
