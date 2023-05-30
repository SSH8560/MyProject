package ssh8560.myproject.lostark;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import ssh8560.myproject.web.lostark.*;
import ssh8560.myproject.web.lostark.auction.*;

import java.util.List;

@SpringBootTest
class ApiServiceTest {

    @Autowired
    private ApiService apiService;

    @Autowired
    private List<Skill> skills;

    @Value("${lostark.api.key}")
    private String apiKey;

    @Test
    void searchItemFromAuction() {
        AuctionItemRequest auctionItemRequest = AuctionItemRequest.builder(CategoryCode.보석)
                .itemName("10레벨 멸화")
                .sortCondition(SortCondition.ASC)
                .skillOption(SearchDetailOption.builder().firstOption(37350).secondOption(500).build())
                .sort(Sort.BUY_PRICE)
                .build();

        Assertions.assertThatCode(() -> {
            AuctionItemResponse auctionItemResponse = apiService.searchItemFromAuction(auctionItemRequest, apiKey).block();
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

    @Test
    void searchItemFromAuctionWithSkills() {
        for (Skill skill : skills) {
            for (Tripod tripod : skill.getTripods()) {
                if (!tripod.isGem()) {
                    AuctionItemRequest auctionItemRequest = AuctionItemRequest.builder(CategoryCode.아뮬렛)
                            .skillOption(SearchDetailOption.builder()
                                    .firstOption(skill.getValue())
                                    .secondOption(tripod.getValue())
                                    .minValue(5)
                                    .maxValue(5)
                                    .build())
                            .sort(Sort.BUY_PRICE)
                            .sortCondition(SortCondition.ASC)
                            .build();

                    AuctionItemResponse auctionItemResponse = apiService.searchItemFromAuction(auctionItemRequest, apiKey).block();
                    if (!auctionItemResponse.getItems().isEmpty()) {
                        Item cheapestItem = auctionItemResponse.getItems().get(0);
                        System.out.print(String.format("%s스킬, %s 트라이포드의 최저가는 %d골드 입니다.", skill.getText(), tripod.getText(), cheapestItem.getAuctionInfo().getBuyPrice()));
                    }

                }
            }
        }

    }
}