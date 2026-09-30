package com.example.exception;

public class UsernameAlreadyExistsException extends RuntimeException{
  public UsernameAlreadyExistsException(String messsage){
    super(messsage);
  }
}
