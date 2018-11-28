package com.rentaladda.model;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

/*    @Profile("dev")
    public void initDevJdbcTemplate();

    @Profile("uat")
    public void initUatJdbcTemplate();

    @Profile("prod")
    public void initProdJdbcTemplate();*/

    public User findByName(String name);
}
