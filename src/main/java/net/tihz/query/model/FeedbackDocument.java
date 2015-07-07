package net.tihz.query.model;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;
import java.util.List;

public class FeedbackDocument {

    @Field
    private Integer id;

    @Field("channel")
    private List<String> channels;

    @Field("creation.creationDate")
    private Date creationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getChannels() {
        return channels;
    }

    public void setChannels(List<String> channels) {
        this.channels = channels;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
