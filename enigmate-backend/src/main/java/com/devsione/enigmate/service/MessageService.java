package com.devsione.enigmate.service;

import com.devsione.enigmate.dto.MessageDTO;
import com.devsione.enigmate.model.Cipher;
import com.devsione.enigmate.model.Message;
import com.devsione.enigmate.model.User;
import com.devsione.enigmate.repository.MessageRepository;
import com.devsione.enigmate.util.VigenereUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final UserService userService;
    private final CipherService cipherService;

    public MessageService(MessageRepository messageRepository, UserService userService, CipherService cipherService) {
        this.messageRepository = messageRepository;
        this.userService = userService;
        this.cipherService = cipherService;
    }

    public List<Message> findBySender(Long senderId){
        User sender = userService.findById(senderId).orElse(null);
        List<Message> outbox = new ArrayList<>();
        if (sender != null) {
           outbox = messageRepository.findBySender(sender);
        }
        return outbox;
    }

    public List<MessageDTO> findByReceiver(Long senderId){
        User receiver = userService.findById(senderId).orElse(null);
        List<MessageDTO> inbox = new ArrayList<>();
        if (receiver != null) {
            inbox = messageRepository.findByReceiver(receiver).stream()
                    .map(message -> new MessageDTO(
                            message.getId(),
                            message.getSender().getUsername(),
                            message.getReceiver().getUsername(),
                            message.getCipher().getName(),
                            message.getEncodedMessage(),
                            message.getDateCreated()
                    )).collect(Collectors.toList());
        }
        return inbox;
    }

    public List<Message> findAll() {
        return (List<Message>) messageRepository.findAll();
    }

    public void delete(Long id){
        messageRepository.deleteById(id);
    }

    public Message sendMessage(MessageDTO messageDTO){
        /*message.setDateCreated(LocalDateTime.now());*/

        User sender = userService.findByUsername(messageDTO.getSender());
        User receiver = userService.findByUsername(messageDTO.getReceiver());
        Cipher cipher = cipherService.findByName(messageDTO.getCipher());
        LocalDateTime sentAt = LocalDateTime.now();
        String encoded = VigenereUtil.encode(messageDTO.getRawMessage(), cipher.getKey());

        Message message = new Message(sender, receiver, cipher, sentAt, encoded);
        messageRepository.save(message);
        /*message.setSender(sender);
        message.setReceiver(receiver);
        message.setCipher(cipher);
        message.setEncodedMessage(encoded);*/


        return message;
    }
}
