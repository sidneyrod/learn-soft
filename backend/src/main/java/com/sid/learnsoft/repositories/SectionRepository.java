package com.sid.learnsoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sid.learnsoft.entities.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long>{

}
