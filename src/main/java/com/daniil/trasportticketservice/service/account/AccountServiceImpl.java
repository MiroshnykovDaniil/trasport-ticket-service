package com.daniil.trasportticketservice.service.account;

import com.daniil.trasportticketservice.model.Account;
import com.daniil.trasportticketservice.repository.AccountRepository;
import com.daniil.trasportticketservice.service.passengerType.PassengerTypeService;
import com.daniil.trasportticketservice.service.passengerType.PassengerTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private PassengerTypeService passengerTypeService;

    @Autowired
    private AccountRepository repository;

    @Override
    public Account createAccount(String name, String passengerTypeId) {
        Account account = new Account();
        account.setName(name);
        account.setPassengerType(passengerTypeService.get(passengerTypeId));
        return repository.save(account);
    }

    @Override
    public Account updatePassengerType(String id, String passengerTypeId) {
        Account account = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account:"+"id:"+id));
        account.setPassengerType(passengerTypeService.get(id));
        return repository.save(account);
    }
}
