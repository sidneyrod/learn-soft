package com.sid.learnsoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sid.learnsoft.entities.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long>{

}
