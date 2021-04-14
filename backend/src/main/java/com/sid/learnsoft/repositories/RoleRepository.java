package com.sid.learnsoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sid.learnsoft.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
