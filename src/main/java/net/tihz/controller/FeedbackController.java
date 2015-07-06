package net.tihz.controller;

import net.tihz.model.Feedback;
import net.tihz.service.FeedbackService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;


@Controller
public class FeedbackController {

    @Inject
    private FeedbackService service;

    @RequestMapping("/feedback")
    @ResponseBody
    public Feedback load(Long id) {
        return service.load(id);
    }

}
