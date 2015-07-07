package net.tihz.repository.core;

import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CoreRepository<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected JPAQuery<T> query() {
        return new JPAQuery(entityManager);
    }
}
