package com.atguigu.springcloud.service.Impl;

/**
 * @Author:hejr
 * @Description:
 * @Date: 2019/3/25 13:57
 */

public class News {
    String content;
    String newsId;
    String url;
    String title;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
