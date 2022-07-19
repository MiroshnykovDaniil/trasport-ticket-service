package com.daniil.trasportticketservice.destination;

import com.daniil.trasportticketservice.model.Destination;
import com.daniil.trasportticketservice.repository.DestinationRepository;
import com.daniil.trasportticketservice.service.destination.DestinationService;
import com.daniil.trasportticketservice.service.destination.DestinationServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DestinationServiceTests {

    @Mock
    DestinationRepository destinationRepository;

    @InjectMocks
    DestinationServiceImpl destinationService;

    @Test
    public void whenCreateDestinationItShouldReturnDestinationWithTitle(){
        String title = "Kyiv";
        Destination destination = new Destination();
        destination.setTitle("Kyiv");

        when(destinationRepository.save(any(Destination.class))).thenReturn(destination);
        Destination created = destinationService.addDestination(title);
        assertThat(created.getTitle()).isSameAs(title);
    }
}
