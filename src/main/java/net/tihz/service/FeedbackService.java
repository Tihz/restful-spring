package net.tihz.service;

import net.tihz.model.Feedback;
import net.tihz.query.FeedbackQuery;
import net.tihz.query.model.FeedbackDocument;
import net.tihz.repository.FeedbackRepository;
import net.tihz.repository.model.FeedbackEntity;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository repository;

    @Autowired
    private FeedbackQuery query;

    private DozerBeanMapper mapper = new DozerBeanMapper();

    @Transactional
    public Feedback load(Long id) {
        FeedbackEntity entity = repository.load(id);
        return mapper.map(entity, Feedback.class);
    }

    @Transactional
    public Long count(String organisationName) {
        return repository.count(organisationName);
    }

    @Transactional
    public List<Feedback> solr() {
        List<FeedbackDocument> documents = query.find();
        return documents.stream().map(document -> (mapper.map(document, Feedback.class))).collect(Collectors.toList());
    }
}
