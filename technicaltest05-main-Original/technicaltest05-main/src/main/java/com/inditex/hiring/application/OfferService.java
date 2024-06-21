package com.inditex.hiring.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.hiring.infraestructure.repository.Offer;
import com.inditex.hiring.infraestructure.repository.OfferRepository;

@Service
public class OfferService {

    @Autowired
    private final OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public List<Offer> findAll() {
        return offerRepository.findAll();
    }

    public Optional<Offer> findById(Long id) {
        return Optional.ofNullable(offerRepository.findById(id));
    }

    public Offer save(Offer offer) {
        return offerRepository.save(offer);
    }

    public void deleteById(Long id) {
        offerRepository.deleteById(id);
    }

    //add wilmer
    public void deleteAllOffers(){
        offerRepository.deleteAllOffers();
    }
}