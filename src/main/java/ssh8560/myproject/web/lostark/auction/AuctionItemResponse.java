package ssh8560.myproject.web.lostark.auction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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
    private List<Item> items = new ArrayList<>();
}


