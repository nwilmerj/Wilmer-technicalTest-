package com.inditex.hiring.infraestructure.repository;

public interface ICustomOfferRepository {

    Offer findById(Long id);

    void deleteById(Long id);

    void deleteAllOffers();
}
