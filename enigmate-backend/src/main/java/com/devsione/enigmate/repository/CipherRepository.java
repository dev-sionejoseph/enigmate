package com.devsione.enigmate.repository;

import com.devsione.enigmate.model.Cipher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CipherRepository extends CrudRepository<Cipher, Long> {

    Cipher findByName(String name);

    void deleteById(Long id);
}