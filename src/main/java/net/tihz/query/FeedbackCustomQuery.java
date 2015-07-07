package net.tihz.query;

import net.tihz.query.model.FeedbackChannelFacet;
import net.tihz.query.model.FeedbackDocument;

import java.util.List;

public interface FeedbackCustomQuery {

    public List<FeedbackDocument> find();

    public List<FeedbackChannelFacet> facet();
}