package net.tihz.query;

import net.tihz.query.model.FeedbackChannelFacet;
import net.tihz.query.model.FeedbackDocument;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class FeedbackQueryImpl implements FeedbackCustomQuery {

    @Autowired
    private SolrServer solrServer;

    public List<FeedbackDocument> find() {

        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");

        QueryResponse response = null;
        try {
            response = solrServer.query(query);
        } catch (SolrServerException e) {
            throw new RuntimeException("Solr Exception", e);
        }
        return response.getBeans(FeedbackDocument.class);

    }


    public List<FeedbackChannelFacet> facet() {

        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
        query.setFacet(true);
        query.addFacetField("channel");

        QueryResponse response = null;
        try {
            response = solrServer.query(query);
        } catch (SolrServerException e) {
            throw new RuntimeException("Solr Exception", e);
        }



        FacetField channel = response.getFacetField("channel");
        return channel.getValues().stream()
                .map(count -> new FeedbackChannelFacet(count))
                .collect(Collectors.toList());
    }
}
