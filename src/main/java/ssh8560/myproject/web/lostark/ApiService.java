package ssh8560.myproject.web.lostark;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriUtils;
import reactor.core.publisher.Mono;
import ssh8560.myproject.web.lostark.auction.AuctionItemRequest;
import ssh8560.myproject.web.lostark.auction.AuctionItemResponse;
import ssh8560.myproject.web.lostark.character.CharacterArmoryResponse;
import ssh8560.myproject.web.lostark.character.CharacterData;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Service
public class ApiService {

    private final WebClient webClient;

    public ApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(ApiUrlConst.URL)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Mono<AuctionItemResponse> searchItemFromAuction(AuctionItemRequest auctionItemRequest, String apiKey) {
        return webClient.post()
                .uri(ApiUrlConst.AUCTIONS_POST)
                .header("authorization", "bearer " + apiKey)
                .bodyValue(auctionItemRequest)
                .retrieve()
                .bodyToMono(AuctionItemResponse.class);
    }

    public Mono<CharacterArmoryResponse> getCharacterData(String characterName, String apiKey, CharacterData... filters) {
        String filter = Arrays.stream(filters)
                .distinct()
                .map(CharacterData::getFilter)
                .reduce((f1, f2) -> f1 + "+" + f2).get();

        return webClient.get()
                .uri(uriBuilder -> UriComponentsBuilder.fromUri(uriBuilder.build())
                        .path(UriUtils.encode(ApiUrlConst.ARMORIES_CHARACTER_GET + "/" + characterName, StandardCharsets.UTF_8))
                        .queryParam("filters", UriUtils.encode(filter, StandardCharsets.UTF_8))
                        .build(true).toUri())
                .header("authorization", "bearer " + apiKey)
                .retrieve()
                .bodyToMono(CharacterArmoryResponse.class);
    }
}
