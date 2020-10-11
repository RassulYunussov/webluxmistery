package com.example.webfluxexperiments.crawler.tengrinews;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author rassulyunussov
 */
@Data
@Slf4j
public class Page {

    private Mono<String> res;

    public Page(WebClient webClient, String url) {
        res = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .cache();
    }
    public Mono<String> getBody() {
           log.info("getting data");
           return res;
    }
}
