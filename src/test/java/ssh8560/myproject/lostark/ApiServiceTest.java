package ssh8560.myproject.lostark;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import ssh8560.myproject.web.lostark.*;
import ssh8560.myproject.web.lostark.auction.*;
import ssh8560.myproject.web.lostark.character.ArmorySkill;
import ssh8560.myproject.web.lostark.character.CharacterArmoryResponse;
import ssh8560.myproject.web.lostark.character.CharacterData;
import ssh8560.myproject.web.lostark.character.SkillTripod;

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
    void searchItemFromAuctionWithSkills() throws InterruptedException {
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
                    Mono<AuctionItemResponse> auctionItemResponseMono = apiService.searchItemFromAuction(auctionItemRequest, apiKey);
                    AuctionItemResponse auctionItemResponse = null;
                    try {
                        auctionItemResponse = auctionItemResponseMono.block();
                    } catch (WebClientResponseException webClientResponseException) {
                        Thread.sleep(60000);
                        auctionItemResponse = auctionItemResponseMono.retry().block();
                    } finally {
                        if (auctionItemResponse.getItems() != null && !auctionItemResponse.getItems().isEmpty()) {
                            Item cheapestItem = auctionItemResponse.getItems().get(0);
                            System.out.println(String.format("%s스킬, %s 트라이포드의 최저가는 %d골드 입니다.", skill.getText(), tripod.getText(), cheapestItem.getAuctionInfo().getBuyPrice()));
                        }
                    }
                }
            }
        }



    }

    @Test
    void searchCharacterCombatSkill() {
        CharacterArmoryResponse characterArmoryResponse = apiService.getCharacterData("헤롱헤롱마븜사", apiKey, CharacterData.COMBAT_SKILL).block();

        List<ArmorySkill> armorySkills = characterArmoryResponse.getArmorySkills();
        for (ArmorySkill armorySkill : armorySkills) {
            if (armorySkill.getLevel() != 1) {
                System.out.println(armorySkill.getName());
                for (SkillTripod tripod : armorySkill.getTripods()) {
                    if (tripod.getIsSelected()) {
                        System.out.println("tripod.getName() = " + tripod.getName());
                    }
                }
            }
        }
    }
}