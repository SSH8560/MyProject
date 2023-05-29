package ssh8560.myproject.lostark.auction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import ssh8560.myproject.lostark.Sort;
import ssh8560.myproject.lostark.SortCondition;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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

    private AuctionItemRequest() {
    }

    public static AuctionItemRequestBuilder builder(CategoryCode categoryCode) {
        return new AuctionItemRequestBuilder(categoryCode);
    }

    public static class AuctionItemRequestBuilder {
        private AuctionItemRequest auctionItemRequest;
        private Integer itemLevelMin;
        private Integer itemLevelMax;
        private Integer itemGradeQuality;
        private Sort sort;
        private String characterClass;
        private Integer itemTier;
        private String itemGrade;
        private String itemName;
        private Integer pageNo;
        private SortCondition sortCondition;
        private CategoryCode categoryCode;
        private List<SearchDetailOption> skillOptions = new ArrayList<>();
        private List<SearchDetailOption> etcOptions = new ArrayList<>();
        public AuctionItemRequestBuilder itemLevelMin(Integer itemLevelMin) {
            this.itemLevelMin = itemLevelMin;
            return this;
        }
        public AuctionItemRequestBuilder itemLevelMax(Integer itemLevelMax) {
            this.itemLevelMax = itemLevelMax;
            return this;
        }
        public AuctionItemRequestBuilder itemGradeQuality(Integer itemGradeQuality) {
            this.itemGradeQuality = itemGradeQuality;
            return this;
        }
        public AuctionItemRequestBuilder sort(Sort sort) {
            this.sort = sort;
            return this;
        }
        public AuctionItemRequestBuilder characterClass(String characterClass) {
            this.characterClass = characterClass;
            return this;
        }

        public AuctionItemRequestBuilder itemTier(Integer itemTier) {
            this.itemTier = itemTier;
            return this;
        }
        public AuctionItemRequestBuilder itemGrade(String itemGrade) {
            this.itemGrade = itemGrade;
            return this;
        }
        public AuctionItemRequestBuilder itemName(String itemName) {
            this.itemName = itemName;
            return this;
        }
        public AuctionItemRequestBuilder pageNo(Integer pageNo) {
            this.pageNo = pageNo;
            return this;
        }
        public AuctionItemRequestBuilder sortCondition(SortCondition sortCondition) {
            this.sortCondition = sortCondition;
            return this;
        }
        public AuctionItemRequestBuilder skillOptions(Integer firstOption, Integer secondOption, Integer minValue, Integer maxValue) {
            this.skillOptions.add(new SearchDetailOption(firstOption, secondOption, minValue, maxValue));
            return this;
        }
        public AuctionItemRequestBuilder etcOptions(Integer firstOption, Integer secondOption, Integer minValue, Integer maxValue) {
            this.etcOptions.add(new SearchDetailOption(firstOption, secondOption, minValue, maxValue));
            return this;
        }

        public AuctionItemRequestBuilder(CategoryCode categoryCode) {
            this.categoryCode = categoryCode;
        }

        public AuctionItemRequest build() {
            AuctionItemRequest auctionItemRequest = new AuctionItemRequest();
            auctionItemRequest.setItemLevelMin(itemLevelMin);
            auctionItemRequest.setItemLevelMax(itemLevelMax);
            auctionItemRequest.setItemGradeQuality(itemGradeQuality);
            auctionItemRequest.setSort(sort);
            auctionItemRequest.setCharacterClass(characterClass);
            auctionItemRequest.setItemTier(itemTier);
            auctionItemRequest.setItemGrade(itemGrade);
            auctionItemRequest.setItemName(itemName);
            auctionItemRequest.setPageNo(pageNo);
            auctionItemRequest.setSortCondition(sortCondition);
            auctionItemRequest.setCategoryCode(categoryCode);
            auctionItemRequest.setSkillOptions(skillOptions);
            auctionItemRequest.setEtcOptions(etcOptions);
            return auctionItemRequest;
        }
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
