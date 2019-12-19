package com.when.spider.controller;

import com.when.spider.response.FertResponse;
import com.when.spider.service.FertSpider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: when
 * @create: 2019-12-13  14:39
 **/
@RestController
@RequestMapping("/spider")
public class FertController {
    private FertSpider spider;

    @Autowired
    public FertController(FertSpider spider) {
        this.spider = spider;
    }

    @GetMapping("/fert")
    public FertResponse extractContent(@RequestParam("url") String targetUrl) {
        return spider.crawlTargetUrl(targetUrl);
    }
}
