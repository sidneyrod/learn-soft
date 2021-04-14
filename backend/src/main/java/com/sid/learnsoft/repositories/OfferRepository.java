package com.sid.learnsoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sid.learnsoft.entities.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long>{

}
