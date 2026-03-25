package com.coforge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.entities.User;
@Repository
public interface UserRepoInterface extends  JpaRepository<User, Long>{

}
