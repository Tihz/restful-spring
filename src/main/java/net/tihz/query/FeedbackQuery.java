package net.tihz.query;

import net.tihz.query.model.FeedbackDocument;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FeedbackQuery {

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
}
