package com.zhy.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
    }

    @Test
    public void encoder(){
        System.out.println(passwordEncoder.encode("secret"));
    }
}
