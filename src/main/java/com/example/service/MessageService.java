package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.exception.InvalidMessageTextException;
import com.example.exception.UserDoesntExistException;
import com.example.exception.InvalidMessageTextException;
import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;

@Service
public class MessageService {
  private MessageRepository messageRepository;
  private AccountRepository accountRepository;

  public MessageService(MessageRepository messageRepository, AccountRepository accountRepository){
    this.messageRepository = messageRepository;
    this.accountRepository = accountRepository;
  }

  public Message createMessage(Message message) throws InvalidMessageTextException, UserDoesntExistException{
    if (!isMessageTextValid(message.getMessageText())){
      throw new InvalidMessageTextException("Message is either blank or too long.");
    }
    accountRepository.findById(message.getPostedBy()).orElseThrow(() -> new UserDoesntExistException("User not found."));
    messageRepository.save(message);
    return messageRepository.findByPostedByAndMessageText(message.getPostedBy(), message.getMessageText()).orElse(null);
  }

  public List<Message> getAllMessages(){
    return messageRepository.findAll();
  }

  public Message getMessageById(int id){
    return messageRepository.findById(id).orElse(null);
  }

  public Integer deleteMessageById(int id){
    Message messageToDelete = getMessageById(id);
    if (messageToDelete != null){
      messageRepository.deleteById(id);
      return 1;
    }
    return null;
  }

  public Integer patchMessageById(int id, String text){
    Message messageToPatch = getMessageById(id);
    if (messageToPatch != null){
      // TODO
    }
    return null;
  }

  // helper function below 
  private boolean isMessageTextValid(String messageText){
    if(messageText == "" || messageText.length() > 255){
      return false;
    }
    return true;
  }
}
