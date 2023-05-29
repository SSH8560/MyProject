package ssh8560.myproject.lostark.auction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class AuctionItemResponse {
    @JsonProperty("PageNo")
    private Integer pageNo;

    @JsonProperty("PageSize")
    private Integer pageSize;

    @JsonProperty("TotalCount")
    private Integer totalCount;

    @JsonProperty("Items")
    private List<Item> items;
}


