package com.rentaladda.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//@Profile("dev")
public interface UserRepositoryDev extends JpaRepository<User,Long> {

    public User findByName(String name);
}
