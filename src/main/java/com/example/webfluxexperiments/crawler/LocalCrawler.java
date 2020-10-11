package com.example.webfluxexperiments.crawler;

import com.example.webfluxexperiments.crawler.tengrinews.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author rassulyunussov
 */
@Slf4j
@Service
public class LocalCrawler {
    private final WebClient webClient;
    private final ConcurrentHashMap<String, Page> pages;


    public LocalCrawler(WebClient.Builder builder) {
        webClient = builder.baseUrl("http://localhost:8080").build();
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
