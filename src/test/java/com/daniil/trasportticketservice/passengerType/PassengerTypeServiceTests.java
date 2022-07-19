package com.daniil.trasportticketservice.passengerType;


import com.daniil.trasportticketservice.model.PassengerType;
import com.daniil.trasportticketservice.repository.PassengerTypeRepository;
import com.daniil.trasportticketservice.service.passengerType.PassengerTypeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class PassengerTypeServiceTests {

    @Mock
    PassengerTypeRepository passengerTypeRepository;

    @InjectMocks
    PassengerTypeServiceImpl passengerTypeService;

    @Test
    public void whenCreatePassengerTypeItShouldReturnPassengerTypeWithTitle(){
        String title = "Passenger";
        PassengerType passengerType = new PassengerType();
        passengerType.setTitle(title);
        passengerType.setDiscountPercent(10);

        when(passengerTypeRepository.save(any(PassengerType.class))).thenReturn(passengerType);
        PassengerType created = passengerTypeService.create(title, 10);
        assertThat(created.getTitle()).isSameAs(title);
        assertThat(created.getDiscountPercent()).isSameAs(10);
    }

    @Test
    public void whenGetPassengerTypeItShouldReturnPassengerTypeWithTitle(){
        String id = "1";
        String title = "Passenger";
        PassengerType passengerType = new PassengerType();
        passengerType.setId(id);
        passengerType.setTitle(title);
        passengerType.setDiscountPercent(10);

        when(passengerTypeRepository.findById(id)).thenReturn(java.util.Optional.of(passengerType));
        PassengerType created = passengerTypeService.get(id);
        assertThat(created.getTitle()).isSameAs(title);
        assertThat(created.getDiscountPercent()).isSameAs(10);
    }

    @Test
    public void whenUpdatePassengerTypeDiscountItShouldReturnPassengerTypeWithDiscountPercent(){
        String id = "1";
        PassengerType passengerType = new PassengerType();
        passengerType.setId(id);
        passengerType.setTitle("Passenger");
        passengerType.setDiscountPercent(10);
        when(passengerTypeRepository.findById(id)).thenReturn(java.util.Optional.of(passengerType));
        when(passengerTypeRepository.save(any(PassengerType.class))).thenReturn(passengerType);
        PassengerType updated = passengerTypeService.updateDiscount(passengerType, 20);
        assertThat(updated.getDiscountPercent()).isSameAs(20);
    }

    @Test
    public void whenRemoveDiscountItShouldReturnPassengerTypeWithDiscountPercent(){
        String id = "1";
        PassengerType passengerType = new PassengerType();
        passengerType.setId(id);
        passengerType.setTitle("Passenger");
        passengerType.setDiscountPercent(10);
        when(passengerTypeRepository.findById(id)).thenReturn(java.util.Optional.of(passengerType));
        when(passengerTypeRepository.save(any(PassengerType.class))).thenReturn(passengerType);
        PassengerType updated = passengerTypeService.removeDiscount(passengerType);
        assertThat(updated.getDiscountPercent()).isSameAs(0);
    }

    @Test
    public void whenDeletePassengerTypeItShouldDeletePassengerType(){
        String id = "1";
        PassengerType passengerType = new PassengerType();
        passengerType.setId(id);
        passengerType.setTitle("Passenger");
        passengerType.setDiscountPercent(10);

        Optional<PassengerType> optional = Optional.empty();
        when(passengerTypeRepository.findById(id)).thenReturn(optional);
        passengerTypeService.delete(passengerType);
        verify(passengerTypeRepository).delete(passengerType);
        assertThatThrownBy(() -> passengerTypeRepository.findById(id).get()).isInstanceOf(NoSuchElementException.class);
    }
}
