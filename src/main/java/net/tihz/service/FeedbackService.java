package net.tihz.service;

import net.tihz.model.Feedback;
import net.tihz.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class FeedbackService {

    @Inject
    private FeedbackRepository repository;

    public Feedback load(Long id) {
        return repository.load(id);
    }
}
