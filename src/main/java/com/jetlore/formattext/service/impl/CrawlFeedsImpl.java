package com.jetlore.formattext.service.impl;

import com.jetlore.formattext.service.CrawlFeeds;

public class CrawlFeedsImpl implements CrawlFeeds {

    public String crawlFeeds () {

        //hardcoded now, but it could be different sources - Twitter, Facebook and other sources
        return "Trump visited Facebook headquarters: http://bit.ly/xyz @elversatile";

    }

}
