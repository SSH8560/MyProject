package ssh8560.myproject.lostark.auction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Item {
    @JsonProperty("Name")
    private String name;

    @JsonProperty("Grade")
    private String grade;

    @JsonProperty("Tier")
    private Integer tier;

    @JsonProperty("Level")
    private Integer level;

    @JsonProperty("Icon")
    private String icon;

    @JsonProperty("GradeQuality")
    private Integer gradeQuality;

    @JsonProperty("AuctionInfo")
    private AuctionInfo auctionInfo;

    @JsonProperty("Options")
    private List<Option> options;
}
