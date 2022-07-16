package com.daniil.trasportticketservice.service;

public interface AccountService {

    void createAccount(String name, String passengerTypeId);

    void updatePassengerType(String id, String passengerTypeId);

}
