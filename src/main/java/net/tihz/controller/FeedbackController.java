package net.tihz.controller;

import net.tihz.model.Feedback;
import net.tihz.service.FeedbackService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;


@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Inject
    private FeedbackService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Feedback load(@PathVariable Long id) {
        return service.load(id);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Long load(String organisationName) {
        return service.count(organisationName);
    }

    @RequestMapping(value = "/solr", method = RequestMethod.GET)
    public List<Feedback> solr() {
        return service.solr();
    }
}
