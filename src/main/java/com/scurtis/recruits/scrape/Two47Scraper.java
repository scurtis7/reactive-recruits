package com.scurtis.recruits.scrape;

import com.scurtis.recruits.dto.Two47;
import com.scurtis.recruits.scrape.exception.WebScrapingException;
import com.scurtis.recruits.storage.DataAccess;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Steve Curtis
 * Date: Apr 26, 2020
 **/

@Slf4j
public class Two47Scraper {

    private final WebScrapingService webScrapingService;
    private final DataAccess dataAccess;

    private static final String HTTPS = "https:";
    private static final String BASE_URL = "https://247sports.com/college/";
    private static final String SEASON = "/Season/";
    private static final String FOOTBALL_COMMITS = "-Football/Commits/";

    public Two47Scraper(WebScrapingService webScrapingService, DataAccess dataAccess) {
        this.webScrapingService = webScrapingService;
        this.dataAccess = dataAccess;
    }

    public Flux<Two47> scrape(String college, String season) {
        log.info("Method: scrape()");
        try {
            String website = BASE_URL + college + SEASON + season + FOOTBALL_COMMITS;
            Document doc = webScrapingService.scrape(website);
            if (doc != null) {
                return dataAccess.saveRecruits(parse(doc, season, college));
            }
        } catch (WebScrapingException exception) {
            log.error("Exception encountered while getting 247 recruits: {}", exception.getMessage());
        }
        return Flux.empty();
    }

    private List<Two47> parse(Document doc, String season, String college) {
        log.info("Document Title: {}", doc.title());
        List<Element> anchors = doc.getElementsByClass("ri-page__name-link");
        return getCommits(anchors, season, college);
    }

    private List<Two47> getCommits(List<Element> anchors, String season, String college) {
        List<Two47> commits = new ArrayList<>();
        anchors.forEach(anchor -> {
            String href = anchor.attr("href");
            String id = href.substring(href.lastIndexOf('-') + 1);
            String website = HTTPS + href;
            try {
                Document doc = webScrapingService.scrape(website);
                commits.add(getPlayer(doc, id, season, website, college));
            } catch (WebScrapingException sce) {
                // Just ignore for now
                log.error(sce.getMessage());
            }
        });
        return commits;
    }

    private Two47 getPlayer(Document doc, String id, String season, String url, String college) {
        Two47 player = new Two47();
        player.setCollege(college);
        player.setSiteId(Integer.valueOf(id));
        player.setYear(Integer.valueOf(season));
        player.setLink(url);
        player.setName(doc.getElementsByClass("name").first().text());
        Element metrics = doc.getElementsByClass("metrics-list").first();
        List<Element> listItems = metrics.select("li");
        listItems.forEach(listItem -> {
            if (listItem.selectFirst("span").text().contains("Pos")) {
                player.setPosition(listItem.select("span").get(1).text());
            } else if (listItem.selectFirst("span").text().contains("Height")) {
                player.setHeight(listItem.select("span").get(1).text());
            } else if (listItem.selectFirst("span").text().contains("Weight")) {
                player.setWeight(listItem.select("span").get(1).text());
            }
        });

        Element details = doc.getElementsByClass("details").first();
        listItems = details.select("li");
        listItems.forEach(listItem -> {
            if (listItem.selectFirst("span").text().contains("High School")) {
                player.setHighSchool(listItem.select("span").get(1).select("a").text());
            } else if (listItem.selectFirst("span").text().contains("Home Town")) {
                player.setHomeTown(listItem.select("span").get(1).text());
            }
        });

        Elements rankElements = doc.getElementsByClass("rank-block");
        if (rankElements != null) {
            player.setCompositeRank(rankElements.first().text());
        }

        Element starsBlock = doc.getElementsByClass("stars-block").first();
        if (starsBlock != null) {
            List<Element> starElements = starsBlock.select("span");
            long stars = starElements.stream().filter(span -> span.className().contains("yellow")).count();
            player.setStars((int) stars);
        } else {
            player.setStars(0);
        }

        Element rankList = doc.getElementsByClass("ranks-list").first();
        if (rankList != null) {
            rankList.select("li").forEach(rankItem -> {
                if (rankItem.selectFirst("b").text().contains("Natl")) {
                    player.setRankNational(stringToInteger(rankItem.selectFirst("strong").text()));
                } else if (rankItem.selectFirst("a").attr("href").contains("Position=")) {
                    player.setRankPosition(stringToInteger(rankItem.selectFirst("strong").text()));
                } else if (rankItem.selectFirst("a").attr("href").contains("State=")) {
                    player.setRankState(stringToInteger(rankItem.selectFirst("strong").text()));
                }
            });
        } else {
            player.setRankNational(0);
            player.setRankPosition(0);
            player.setRankState(0);
        }

        return player;
    }

    private Integer stringToInteger(String value) {
        if (StringUtils.isEmpty(value) || value.equalsIgnoreCase("N/A")) {
            return 0;
        } else {
            return Integer.valueOf(value);
        }
    }

}
