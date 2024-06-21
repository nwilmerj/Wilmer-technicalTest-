package com.inditex.hiring.infraestructure.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface OfferRepository extends JpaRepository<Offer, Long>, ICustomOfferRepository {

    @Query("SELECT o FROM Offer o WHERE o.id = :id")
    @Override
    Offer findById(@Param("id") Long id);
    
    @Modifying
    @Transactional
    @Query("DELETE FROM Offer o WHERE o.id = :id")
    void deleteById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Offer")
    void deleteAllOffers();
    
}