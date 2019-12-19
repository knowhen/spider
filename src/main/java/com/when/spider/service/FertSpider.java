package com.when.spider.service;

import com.when.spider.response.FertResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author: when
 * @create: 2019-12-13  14:43
 **/
@Service
public class FertSpider {
    public FertResponse crawlTargetUrl(String targetUrl) {
        validateTargetUrl(targetUrl);
        Document document;
        try {
            document = Jsoup.connect(targetUrl).get();
            String title = getArticleTitle(document);
            String content = getArticleContent(document);
            return new FertResponse(title, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void validateTargetUrl(String targetUrl) {
        if (targetUrl == null || targetUrl.length() == 0) {
            throw new IllegalArgumentException("Invalid url");
        }
    }

    private String getArticleTitle(Document document) {
        String title = "";
        Elements elements = document.getElementsByClass("article-title");
        Element element = elements.get(0);
        if (element.hasText()) {
            Elements tagElements = element.getElementsByTag("h1");
            Element firstTag = tagElements.get(0);
            title = firstTag.text();
        }
        return title;
    }

    private String getArticleContent(Document document) {
        String content = "";
        Elements elements = document.getElementsByClass("article-conte-infor");
        Element element = elements.get(0);
        if (element.hasText()) {
            content = element.text();
        }
        return content;
    }
}
