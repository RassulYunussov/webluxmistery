package com.example.webfluxexperiments.controllers;

import com.example.webfluxexperiments.crawler.LocalCrawler;
import com.example.webfluxexperiments.crawler.TengriNewsCrawler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author rassulyunussov
 */
@RestController
@Slf4j
public class CrawlerController {
    private final TengriNewsCrawler tengriNewsCrawler;
    private final LocalCrawler localCrawler;

    public CrawlerController(TengriNewsCrawler tengriNewsCrawler, LocalCrawler localCrawler) {
        this.tengriNewsCrawler = tengriNewsCrawler;
        this.localCrawler = localCrawler;
    }

    @GetMapping("/local")
    public Mono<String> getHello() {
        return localCrawler.getPage("hello").getBody();
    }
    @GetMapping("/tengri")
    public Mono<String> getPage() {
        return tengriNewsCrawler.getPage("/medicine/vrachi-nazvali-novyie-simptomyi-covid-19-416620/").getBody();
    }
}
