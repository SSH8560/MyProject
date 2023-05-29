package ssh8560.myproject.lostark;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ssh8560.myproject.lostark.auction.*;
import java.util.List;

@SpringBootTest
class ApiServiceTest {

    @Autowired
    private ApiService apiService;
    @Test
    void searchItemFromAuction() {
        AuctionItemRequest auctionItemRequest = AuctionItemRequest.builder(CategoryCode.보석)
                .itemName("10레벨 멸화")
                .sortCondition(SortCondition.ASC)
                .sort(Sort.BUY_PRICE)
                .build();

        Assertions.assertThatCode(()-> {
            AuctionItemResponse auctionItemResponse = apiService.searchItemFromAuction(auctionItemRequest).block();
            List<Item> items = auctionItemResponse.getItems();
            for (Item item : items) {
                System.out.println("--------------------------------");
                System.out.println("item.getName() = " + item.getName());
                for (Option option : item.getOptions()) {
                    System.out.println("option.getClassName() = " + option.getClassName());
                    System.out.println("option.getOptionName() = " + option.getOptionName());
                }
                AuctionInfo auctionInfo = item.getAuctionInfo();
                System.out.println("auctionInfo.getBuyPrice() = " + auctionInfo.getBuyPrice());
                System.out.println("--------------------------------");

            }
        }).doesNotThrowAnyException();
    }
}