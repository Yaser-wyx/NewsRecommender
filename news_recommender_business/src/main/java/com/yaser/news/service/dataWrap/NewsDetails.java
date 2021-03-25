package com.yaser.news.service.dataWrap;

import lombok.Data;

@Data

public class NewsDetails {
    private String docId;
    private String title;
    private Integer createTime;
    private String channelName;
    private String htmlContent;
    private String keywords;
    private String mediaName;
    private Integer commentTotal;
    private Integer viewCount;
    private String author;
}