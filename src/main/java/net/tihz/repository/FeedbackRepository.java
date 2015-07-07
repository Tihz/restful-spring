package net.tihz.repository;

import net.tihz.jooq.tables.Feedback;
import net.tihz.repository.model.FeedbackEntity;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FeedbackRepository {

    @Autowired
    private DSLContext create;

    private static final Feedback feedback = Feedback.FEEDBACK;

    public Integer count(String organisationName) {
        return create.selectCount()
                .from(feedback)
                .where(feedback.ORGANISATION_NAME.eq(organisationName))
                .fetchOneInto(Integer.class);
    }

    public FeedbackEntity load(Long id) {

        return create.select()
                .from(feedback)
                .where(feedback.ID.eq(id))
                .fetchOneInto(FeedbackEntity.class);
    }

}
