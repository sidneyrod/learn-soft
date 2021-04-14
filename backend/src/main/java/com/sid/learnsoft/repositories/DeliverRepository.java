package com.sid.learnsoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sid.learnsoft.entities.Deliver;

@Repository
public interface DeliverRepository extends JpaRepository<Deliver, Long>{

}
