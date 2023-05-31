package com.example.dragi.repositories.impl;

import com.example.dragi.models.Review;
import com.example.dragi.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public Review save(Review review) {
        return entityManager.merge(review);
    }

    @Override
    @Transactional
    public void update(Review review) {
        entityManager.createQuery(
                        "UPDATE Review SET product = :product, user = :user, text = :text where id = :id")
                .setParameter("product", review.getProduct())
                .setParameter("user", review.getUser())
                .setParameter("text", review.getText())
                .setParameter("id", review.getId())
                .executeUpdate();
    }

    @Override
    public List<Review> findAllByProductId(Long product) {
        TypedQuery<Review> query = entityManager.createQuery(
                "SELECT r FROM Review r WHERE r.product IN (SELECT p FROM Product p WHERE p.id=:product)", Review.class
        );
        query.setParameter("product", product);
        return query.getResultList();
    }

    @Transactional
    public void deleteById(Long reviewId) {
        int isSuccessful = entityManager.createQuery("delete from Review p where p.id=:id")
                .setParameter("id", reviewId)
                .executeUpdate();
        if (isSuccessful == 0) {
            throw new OptimisticLockException(" product modified concurrently");
        }
    }

    @Override
    public List<Review> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Review> criteriaQuery = criteriaBuilder.createQuery(Review.class);
        Root<Review> variableRoot = criteriaQuery.from(Review.class);
        criteriaQuery.select(variableRoot).orderBy();
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Review findById(Long id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Review> criteriaQuery = cb.createQuery(Review.class);
        Root<Review> reviewRoot = criteriaQuery.from(Review.class);
        Predicate predicate = cb.equal(reviewRoot.get("id"), id);
        criteriaQuery.where(predicate);
        TypedQuery<Review> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }
}
