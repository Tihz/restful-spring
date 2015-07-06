package net.tihz.repository;

import net.tihz.model.Feedback;
import org.springframework.stereotype.Repository;


@Repository
public class FeedbackRepository  {

    public Feedback load(Long id) {
        Feedback feedback = new Feedback();
        feedback.setId(1l);
        feedback.setTitle("Hello");
        feedback.setText("Hello World !");
        return feedback;
    }
}
