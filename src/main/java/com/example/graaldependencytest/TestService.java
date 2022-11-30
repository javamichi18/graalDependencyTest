package com.example.graaldependencytest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
//@Component
public class TestService {

    private static final Logger log = LoggerFactory.getLogger( TestService.class );


    public TestService() {
    }


    public void foo(String bar) {
        log.info(" > service: "+bar);
    }
}
