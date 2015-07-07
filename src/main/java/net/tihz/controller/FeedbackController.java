package net.tihz.controller;

import net.tihz.query.model.FeedbackChannelFacet;
import net.tihz.query.model.FeedbackDocument;
import net.tihz.repository.model.FeedbackEntity;
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
    public FeedbackEntity load(@PathVariable Long id) {
        return service.load(id);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Integer count(String organisationName) {
        return service.count(organisationName);
    }

    @RequestMapping(value = "/solr", method = RequestMethod.GET)
    public List<FeedbackDocument> solr() {
        return service.solr();
    }

    @RequestMapping(value = "/content", method = RequestMethod.GET)
    public List<FeedbackDocument> content(String title, String text) {
        return service.content(title, text);
    }

    @RequestMapping(value = "/facet", method = RequestMethod.GET)
    public List<FeedbackChannelFacet> facet() {
        return service.facet();
    }
}
