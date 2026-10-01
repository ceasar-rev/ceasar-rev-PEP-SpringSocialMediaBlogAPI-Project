package com.example.exception;

public class InvalidMessagePatchRequestException extends RuntimeException{
  public InvalidMessagePatchRequestException(String message){
    super(message);
  }
}
