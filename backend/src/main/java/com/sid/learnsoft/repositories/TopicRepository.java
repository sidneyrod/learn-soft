package com.sid.learnsoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sid.learnsoft.entities.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long>{

}
