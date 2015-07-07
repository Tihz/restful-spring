package net.tihz.service;

import net.tihz.query.FeedbackQuery;
import net.tihz.query.model.FeedbackChannelFacet;
import net.tihz.query.model.FeedbackDocument;
import net.tihz.repository.FeedbackRepository;
import net.tihz.repository.model.FeedbackEntity;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository repository;

    @Autowired
    private FeedbackQuery query;

    @Transactional
    public FeedbackEntity load(Long id) {
        return repository.load(id);
    }

    @Transactional
    public Integer count(String organisationName) {
        return repository.count(organisationName);
    }

    @Transactional
    public List<FeedbackDocument> solr() {
        return IteratorUtils.toList(query.findAll().iterator());
    }

    @Transactional
    public List<FeedbackDocument> content(String title, String text) {

        if (title == null && text == null) {
            throw new RuntimeException("title and text must not be null");
        }

        if (title == null) {
            return query.findByTextContains(text);
        }

        if (text == null) {
            return query.findByTitleContains(title);
        }

        return query.findByTitleContainsAndTextContains(title, text);
    }

    @Transactional
    public List<FeedbackChannelFacet> facet() {
        return query.facet();
    }
}
