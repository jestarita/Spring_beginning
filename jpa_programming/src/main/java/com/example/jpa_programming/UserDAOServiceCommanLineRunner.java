package com.example.jpa_programming;

import com.example.jpa_programming.models.User;
import com.example.jpa_programming.services.UserDAOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDAOServiceCommanLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UserDAOServiceCommanLineRunner.class);

    @Autowired
    private UserDAOService userDAOService;

    @Override
    public void run(String... arg0) throws Exception{

        User user = new User("USO CARRUSO", "user");
        long inser = userDAOService.insert(user);
        log.info("user created "+user);
    }
}
