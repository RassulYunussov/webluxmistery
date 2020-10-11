package com.example.webfluxexperiments.crawler;

import com.example.webfluxexperiments.crawler.tengrinews.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author rassulyunussov
 */
@Service
@Slf4j
public class TengriNewsCrawler {
    private final WebClient webClient;
    private final ConcurrentHashMap<String, Page> pages;
    public TengriNewsCrawler(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://tengrinews.kz").build();
        pages = new ConcurrentHashMap<>();
    }
    public Page getPage(String url) {
        if(pages.containsKey(url)) {
            return pages.get(url);
        } else {
            Page p = new Page(webClient,url);
            pages.put(url,p);
            return p;
        }
    }
}
