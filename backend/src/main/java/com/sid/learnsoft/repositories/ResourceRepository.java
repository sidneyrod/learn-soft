package com.sid.learnsoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sid.learnsoft.entities.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long>{

}
