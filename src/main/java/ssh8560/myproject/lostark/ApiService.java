package ssh8560.myproject.lostark;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ssh8560.myproject.lostark.auction.AuctionItemRequest;
import ssh8560.myproject.lostark.auction.AuctionItemResponse;

@Service
public class ApiService {

    private final String apiKey;
    private final WebClient webClient;

    public ApiService(@Value("${lostark.api.key}") String apiKey, WebClient.Builder webClientBuilder) {
        this.apiKey = apiKey;
        this.webClient = webClientBuilder.baseUrl(ApiUrlConst.URL)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("authorization", apiKey)
                .build();
    }

    public Mono<AuctionItemResponse> searchItemFromAuction(AuctionItemRequest auctionItemRequest) {
        return webClient.post()
                .uri(ApiUrlConst.AUCTIONS_POST)
                .bodyValue(auctionItemRequest)
                .retrieve()
                .bodyToMono(AuctionItemResponse.class);
    }
}
