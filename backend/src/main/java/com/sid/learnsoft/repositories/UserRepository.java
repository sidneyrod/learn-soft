package com.sid.learnsoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sid.learnsoft.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
