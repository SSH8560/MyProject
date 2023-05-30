package ssh8560.myproject.web.lostark;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ssh8560.myproject.web.lostark.auction.AuctionItemRequest;
import ssh8560.myproject.web.lostark.auction.AuctionItemResponse;

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
}
