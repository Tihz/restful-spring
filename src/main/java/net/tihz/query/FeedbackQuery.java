package net.tihz.query;

import net.tihz.query.model.FeedbackDocument;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

public interface FeedbackQuery extends SolrCrudRepository<FeedbackDocument, String>, FeedbackCustomQuery {

    public List<FeedbackDocument> findByTitleContainsAndTextContains(String title, String text);

    public List<FeedbackDocument> findByTitleContains(String title);

    public List<FeedbackDocument> findByTextContains(String text);
}
