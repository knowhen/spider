package com.when.spider.response;

/**
 * @author: when
 * @create: 2019-12-13  14:50
 **/
public class FertResponse {
    private String title;
    private String content;

    public FertResponse() {
    }

    public FertResponse(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
