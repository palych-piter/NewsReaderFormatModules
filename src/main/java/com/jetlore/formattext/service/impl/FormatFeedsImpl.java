package com.jetlore.formattext.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import com.jetlore.formattext.Concepts;
import com.jetlore.formattext.service.FormatFeeds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FormatFeedsImpl implements FormatFeeds {

    public static final Logger logger = LoggerFactory.getLogger(FormatFeeds.class);

    public String formatFeeds (String feed, List<Concepts> concepts)  {

        Properties prop = new Properties();
        InputStream input = null;
        StringBuilder feedSb = new StringBuilder(feed);

        //order concepts based on the start position
        Collections.sort(concepts, (Concepts s1, Concepts s2) ->{
            return s2.getStartPosition().compareTo(s1.getStartPosition());
        });

        try {
            //read the property file to get all possible types to replace
            input = new FileInputStream("formattext.properties");
            prop.load(input);

            //iterate through concepts, starting from the biggest start position number
            for (int i = 0; i < concepts.size(); i++) {

                //if the corresponding property exists
                if (prop.getProperty(concepts.get(i).getEntity()) != null) {

                    //detect corresponding tags
                    String[] tagsList = prop.getProperty(concepts.get(i).getEntity()).split(",");

                    //adjust positions for a twitter username
                    Integer startPosition = concepts.get(i).getEntity().equals("username") ? concepts.get(i).getStartPosition() + 1 : concepts.get(i).getStartPosition();
                    Integer endPosition   = concepts.get(i).getEndPosition();
                    String  emptySpace    = concepts.get(i).getEntity().equals("username") ? " " : "";

                    //replace substring based on positions and entity type
                    feedSb.replace(startPosition, endPosition,
                            emptySpace + tagsList[0]
                                    .replace(concepts.get(i).getEntity(), feedSb.substring(startPosition, endPosition)) +
                                    feedSb.substring(startPosition, endPosition) +
                            tagsList[1]
                    );
                    logger.info("Concept: " + concepts.get(i).getEntity() + " handled");
                } else {
                    logger.error("Concept: " + concepts.get(i).getEntity() + " has no the corresponding tag in the property file");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return feedSb.toString();
    }
}
