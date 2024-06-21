package com.inditex.hiring.infraestructure.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class CustomOfferRepositoryImpl implements ICustomOfferRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Offer findById(Long id) {
        return entityManager.find(Offer.class, id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Offer offer = entityManager.find(Offer.class, id);
        if (offer != null) {
            entityManager.remove(offer);
        }
    }

    @Override
    @Transactional
    public void deleteAllOffers() {
        entityManager.createQuery("DELETE FROM Offer").executeUpdate();
    }

}
