package com.daniil.trasportticketservice.destination;

import com.daniil.trasportticketservice.model.Destination;
import com.daniil.trasportticketservice.repository.DestinationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@TestPropertySource(properties = {"DB_USER = root","DB_PASS = "})
class DestinationTest {

    @Autowired
    DestinationRepository destinationRepository;


    @Test
    void createTest(){
        Destination destination = new Destination();
        destination.setTitle("City");
        destinationRepository.save(destination);
        assertThat(destinationRepository.findByTitle("City")).isNotNull();
    }

}
