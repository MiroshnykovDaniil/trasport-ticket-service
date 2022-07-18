package com.daniil.trasportticketservice.service.account;

import com.daniil.trasportticketservice.model.Account;

public interface AccountService {

    Account createAccount(String name, String passengerTypeId);

    Account updatePassengerType(String id, String passengerTypeId);

}
