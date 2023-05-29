package ssh8560.myproject.lostark.auction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
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
    @Singular
    private List<SearchDetailOption> skillOptions;

    @JsonProperty("EtcOptions")
    @Singular
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

