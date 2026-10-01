package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {  
  @ExceptionHandler(UsernameAlreadyExistsException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public String handleUsernameAlreadyExists(UsernameAlreadyExistsException ex){return ex.getMessage();}

  @ExceptionHandler(InvalidUsernameOrPasswordException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String handleInvalidUsernameOrPassword(InvalidUsernameOrPasswordException ex){return ex.getMessage();}

  @ExceptionHandler(InvalidCredentialsException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  public String handleInvalidCredentials(InvalidCredentialsException ex){return ex.getMessage();}

  @ExceptionHandler(InvalidMessageTextException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String handleInvalidMessageText(InvalidMessageTextException ex){return ex.getMessage();}

  @ExceptionHandler(UserDoesntExistException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String handleUserDoesntExist(UserDoesntExistException ex){return ex.getMessage();}

  @ExceptionHandler(InvalidMessagePatchRequestException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String handleInvalidMessagePatchRequest(InvalidMessagePatchRequestException ex){return ex.getMessage();}
}
