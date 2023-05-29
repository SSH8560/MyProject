package ssh8560.myproject.lostark.auction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AuctionInfo {
    @JsonProperty("StartPrice")
    private Integer startPrice;

    @JsonProperty("BuyPrice")
    private Integer buyPrice;

    @JsonProperty("BidPrice")
    private Integer bidPrice;

    @JsonProperty("EndDate")
    private LocalDateTime endDate;

    @JsonProperty("BidCount")
    private Integer bidCount;

    @JsonProperty("BidStartPrice")
    private Integer bidStartPrice;

    @JsonProperty("IsCompetitive")
    private boolean isCompetitive;

    @JsonProperty("TradeAllowCount")
    private Integer tradeAllowCount;
}
