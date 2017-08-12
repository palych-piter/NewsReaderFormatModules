package com.jetlore.formattext;

import java.util.List;

import com.jetlore.formattext.service.CrawlFeeds;
import com.jetlore.formattext.service.ExtractConcepts;
import com.jetlore.formattext.service.FormatFeeds;
import com.jetlore.formattext.service.impl.CrawlFeedsImpl;
import com.jetlore.formattext.service.impl.ExtractConceptsImpl;
import com.jetlore.formattext.service.impl.FormatFeedsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static final Logger logger = LoggerFactory.getLogger(Main.class);

    private static String crawlFeedOutput;
    private static String formatedFeedOutput;
    private static List<Concepts> conceptsOutput ;

    public static void main(String[] args) {

        // crawl string from a source
        CrawlFeeds feeds = new CrawlFeedsImpl();
        crawlFeedOutput = feeds.crawlFeeds();

        //extract concepts from feeds
        ExtractConcepts concepts = new ExtractConceptsImpl();
        conceptsOutput = concepts.extractConcepts(crawlFeedOutput);

        //format the feed
        FormatFeeds formatedFeed = new FormatFeedsImpl();
        formatedFeedOutput = formatedFeed.formatFeeds(crawlFeedOutput, conceptsOutput);

        System.out.printf("Output formatted value: " + formatedFeedOutput);

    }

}
