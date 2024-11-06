package com.devsione.enigmate.controller;

import com.devsione.enigmate.dto.MessageDTO;
import com.devsione.enigmate.model.Message;
import com.devsione.enigmate.model.User;
import com.devsione.enigmate.service.MessageService;
import com.devsione.enigmate.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api/messages")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("")
    List<Message> findAll(){
        return messageService.findAll();
    }

    @GetMapping("{userId}/inbox")
    List<MessageDTO> inbox(@PathVariable Long userId){
        return messageService.findByReceiver(userId);
    }

    @GetMapping("{userId}/outbox")
    List<Message> outbox(@PathVariable Long userId){
        return messageService.findBySender(userId);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("{userId}/send")
    Message sendMessage(@Valid @RequestBody MessageDTO messageDTO){
        return messageService.sendMessage(messageDTO);
    }
}
