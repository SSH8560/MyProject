package ssh8560.myproject.web.lostark.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterArmoryResponse {
    @JsonProperty("ArmorySkills")
    List<ArmorySkill> armorySkills;
}
