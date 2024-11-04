package com.devsione.enigmate.service;

import com.devsione.enigmate.dto.CipherDTO;
import com.devsione.enigmate.dto.CodebreakerDTO;
import com.devsione.enigmate.model.Cipher;
import com.devsione.enigmate.model.User;
import com.devsione.enigmate.repository.CipherRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CipherService {

    private final CipherRepository cipherRepository;
    private final UserService userService;

    public CipherService(CipherRepository cipherRepository, UserService userService) {
        this.cipherRepository = cipherRepository;
        this.userService = userService;
    }

    public Cipher findByName(String name){
        return cipherRepository.findByName(name);
    }

    public List<Cipher> findAll(){
        return (List<Cipher>) cipherRepository.findAll();
    }

    public void createCipher(CipherDTO cipherDTO){
        Set<User> codebreakers = new HashSet<>();
        for(String username : cipherDTO.getCodebreakers()){
            Optional<User> foundUser = Optional.ofNullable(userService.findByUsername(username));
            foundUser.ifPresent(codebreakers::add);
        }
        User user = userService.findById(cipherDTO.getUserId()).orElseThrow(() -> new RuntimeException("Codemaker not found"));
        String name = cipherDTO.getName();
        String key = cipherDTO.getKey();
        Cipher cipher = new Cipher(name, key, user);
        cipher.setCodebreakers(codebreakers);
        cipherRepository.save(cipher);
    }

    public void addCodebreaker(CodebreakerDTO codebreakerDTO){
        User codebreaker = userService.findByUsername(codebreakerDTO.getCodebreaker());
        User codemaker = userService.findByUsername(codebreakerDTO.getCodemaker());
        Cipher cipher = cipherRepository.findByName(codebreakerDTO.getCipherName());
        if ((cipher != null) && (cipher.getCodemaker() == codemaker)){
            cipher.setCodebreaker(codebreaker);
            cipherRepository.save(cipher);
        }
    }

    public Optional<Cipher> findById(Long id){
        return cipherRepository.findById(id);
    }

    public void delete(Long id){
        cipherRepository.deleteById(id);
    }
}
