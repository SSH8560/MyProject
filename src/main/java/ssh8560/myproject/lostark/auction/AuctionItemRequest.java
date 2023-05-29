package ssh8560.myproject.lostark.auction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ssh8560.myproject.lostark.Sort;
import ssh8560.myproject.lostark.SortCondition;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class AuctionItemRequest {
    @JsonProperty("ItemLevelMin")
    private Integer itemLevelMin;

    @JsonProperty("ItemLevelMax")
    private Integer itemLevelMax;

    @JsonProperty("ItemGradeQuality")
    private Integer itemGradeQuality;

    @JsonProperty("SkillOptions")
    private List<SearchDetailOption> skillOptions;

    @JsonProperty("EtcOptions")
    private List<SearchDetailOption> etcOptions;

    @JsonProperty("Sort")
    private Sort sort;

    @JsonProperty("CategoryCode")
    private CategoryCode categoryCode;

    @JsonProperty(value = "CharacterClass")
    private String characterClass;

    @JsonProperty("ItemTier")
    private Integer itemTier;

    @JsonProperty("ItemGrade")
    private String itemGrade;

    @JsonProperty("ItemName")
    private String itemName;

    @JsonProperty("PageNo")
    private Integer pageNo;

    @JsonProperty("SortCondition")
    private SortCondition sortCondition;

    public static AuctionItemRequestBuilder builder(CategoryCode categoryCode) {
        AuctionItemRequestBuilder auctionItemRequestBuilder = new AuctionItemRequestBuilder();
        auctionItemRequestBuilder.categoryCode = categoryCode;
        return auctionItemRequestBuilder;
    }
}

@Getter
@Setter
class SearchDetailOption {
    @JsonProperty("FirstOption")
    private Integer firstOption;

    @JsonProperty("SecondOption")
    private Integer secondOption;

    @JsonProperty("MinValue")
    private Integer minValue;

    @JsonProperty("MaxValue")
    private Integer maxValue;

    public SearchDetailOption(Integer firstOption, Integer secondOption, Integer minValue, Integer maxValue) {
        this.firstOption = firstOption;
        this.secondOption = secondOption;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
}
