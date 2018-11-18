package com.rentaladda.model;

import com.rentaladda.controller.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes={DemoApplication.class})
//@Profile("dev")
public class RepositoryTestDev {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepositoryDev userRepositoryDev;

    @Test
    public void whenSearchName_ThenReturnUser(){

        User use = new User("Bill");
        testEntityManager.persist(use);
        testEntityManager.flush();
        User userDetected = userRepositoryDev.findByName("Bill");
        assertThat(userDetected.getName()).isEqualTo(use.getName());
    }

    @Test
    public void whenSearchName_ThenReturnWrongUser(){

        User use = new User("Ted");
        testEntityManager.persist(use);
        testEntityManager.flush();
        User userDetected = userRepositoryDev.findByName("Bill");
        assertThat(userDetected).isNull();
    }
}
