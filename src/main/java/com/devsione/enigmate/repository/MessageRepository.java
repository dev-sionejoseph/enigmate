package com.devsione.enigmate.repository;

import com.devsione.enigmate.model.Message;
import com.devsione.enigmate.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findBySender(User sender);
    List<Message> findByReceiver(User receiver);

    void deleteById(Long id);
}
