package com.example.service;

import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.exception.InvalidUsernameOrPasswordException;
import com.example.exception.UsernameAlreadyExistsException;
import com.example.repository.AccountRepository;

@Service
public class AccountService {
  private AccountRepository accountRepository;

  public AccountService(AccountRepository accountRepository){
    this.accountRepository = accountRepository;
  }

  public Account createUser(Account account) throws InvalidUsernameOrPasswordException, UsernameAlreadyExistsException{
    if (account.getUsername() == "" || account.getPassword().length() < 4){
      throw new InvalidUsernameOrPasswordException("Username is blank or password is 4 characters or less.");
    }
    if (doesUsernameExist(account.getUsername())){
      throw new UsernameAlreadyExistsException("Username already exists.");
    }
    accountRepository.save(account);
    return accountRepository.findByUsernameAndPassword(account.getUsername(), account.getPassword()).orElse(null);
  }

  private boolean doesUsernameExist(String username){
    Account acc = accountRepository.findByUsername(username).orElse(null);
    if (acc != null){
      return true;
    }
    return false;
  }

}
