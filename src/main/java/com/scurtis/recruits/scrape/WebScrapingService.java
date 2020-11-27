package com.scurtis.recruits.scrape;

import com.scurtis.recruits.scrape.exception.WebScrapingException;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Author: Steve Curtis
 * Date: Apr 26, 2020
 **/

@Slf4j
public class WebScrapingService {

    public Document scrape(String website) throws WebScrapingException {
        log.info("Connect to Website: {}", website);
        try {
            return Jsoup.connect(website).get();
        } catch (IOException exception) {
            log.error("Unable to get rivals website: {}", exception.getMessage());
            throw new WebScrapingException("Unable to get rivals website: " + exception.getMessage(), exception);
        }
    }

}
