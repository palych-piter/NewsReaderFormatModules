package com.jetlore.formattext.service.impl;

import java.util.ArrayList;

import com.jetlore.formattext.Concepts;
import com.jetlore.formattext.service.ExtractConcepts;

public class ExtractConceptsImpl implements ExtractConcepts {

    public ArrayList extractConcepts (String feed) {

        //hardcore populating concepts for this example but could be any implementation
        //based on business needs
        ArrayList<Concepts> concepts = new ArrayList<>();

        //populate the list, order could be different
        concepts.add(new Concepts("entity", 14, 22));
        concepts.add(new Concepts("entity", 0, 5));
        concepts.add(new Concepts("username", 55, 67));
        concepts.add(new Concepts("link", 37, 54));

        return concepts;

    }

}
