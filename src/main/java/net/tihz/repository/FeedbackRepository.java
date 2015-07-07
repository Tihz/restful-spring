package net.tihz.repository;

import com.querydsl.jpa.impl.JPAQuery;
import net.tihz.repository.core.CoreRepository;
import net.tihz.repository.model.FeedbackEntity;
import net.tihz.repository.model.QFeedbackEntity;
import org.springframework.stereotype.Repository;

@Repository
public class FeedbackRepository extends CoreRepository<FeedbackEntity> {

    private static final QFeedbackEntity feedback = QFeedbackEntity.feedbackEntity;

    public FeedbackEntity load(Long id) {

        JPAQuery<FeedbackEntity> query = query();
        query.from(feedback).where(feedback.id.eq(id));
        return query.fetchOne();
    }


    public Long count(String organisationName) {
        JPAQuery<FeedbackEntity> query = query();
        query.from(feedback).where(feedback.organisationName.eq(organisationName));
        return query.fetchCount();
    }
}
