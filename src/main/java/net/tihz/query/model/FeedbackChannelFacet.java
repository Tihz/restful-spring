package net.tihz.query.model;

import org.apache.solr.client.solrj.response.FacetField;

import java.io.Serializable;

public class FeedbackChannelFacet implements Serializable {

    private String name;

    private Long count;

    public FeedbackChannelFacet() {

    }

    public FeedbackChannelFacet(FacetField.Count count) {
        this.name = count.getName();
        this.count = count.getCount();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
