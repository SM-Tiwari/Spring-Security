package com.oneclick.securityjpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneclick.securityjpa.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserName(String userName);

}
