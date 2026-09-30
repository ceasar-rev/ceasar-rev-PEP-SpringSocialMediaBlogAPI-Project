package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.service.AccountService;
import com.example.service.MessageService;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
public class SocialMediaController {
  private AccountService accountService;
  private MessageService messageService;

  public SocialMediaController(AccountService accountService, MessageService messageService){
    this.accountService = accountService;
    this.messageService = messageService;
  }

  @PostMapping("register")
  public ResponseEntity<Account> registerUser(@RequestBody Account account){
    return new ResponseEntity<>(accountService.createUser(account), HttpStatus.OK);
  }

  @PostMapping("login")
  public ResponseEntity<Account> loginUser(@RequestBody Account account){
    return new ResponseEntity<>(accountService.loginUser(account), HttpStatus.OK);
  }

  @PostMapping("messages")
  public ResponseEntity<Message> postMessage(@RequestBody Message message){
    return new ResponseEntity<>(messageService.createMessage(message), HttpStatus.OK);
  }

  @GetMapping("messages")
  public ResponseEntity<List<Message>> getAllMessages(){
    return new ResponseEntity<>(messageService.getAllMessages(), HttpStatus.OK);
  }

  @GetMapping("messages/{messageId}")
  public ResponseEntity<Message> getMessageById(@PathVariable int messageId){
    return new ResponseEntity<>(messageService.getMessageById(messageId), HttpStatus.OK);
  }

  @DeleteMapping("messages/{messageId}")
  public ResponseEntity<Integer> deleteMessageById(@PathVariable int messageId){
    return new ResponseEntity<>(messageService.deleteMessageById(messageId), HttpStatus.OK);
  }

  // TODO: Requirement 7
  @PatchMapping("messages/{messageId}")
  public ResponseEntity<String> patchMessageById(@PathVariable int messageId){
    return ResponseEntity.status(HttpStatus.OK).body("Success");
  }

  // TODO: Requirement 8
  @GetMapping("accounts/{accountId}/messages")
  public ResponseEntity<String> getAllMessagesFromUser(@PathVariable int accountId){
    return ResponseEntity.status(HttpStatus.OK).body("Success");
  }
}
