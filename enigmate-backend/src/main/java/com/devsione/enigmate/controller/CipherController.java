package com.devsione.enigmate.controller;

import com.devsione.enigmate.dto.CipherDTO;
import com.devsione.enigmate.dto.CodebreakerDTO;
import com.devsione.enigmate.model.Cipher;
import com.devsione.enigmate.service.CipherService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/ciphers")
@CrossOrigin(origins = "http://localhost:5173")
public class CipherController {

    private final CipherService cipherService;

    public CipherController(CipherService cipherService) {
        this.cipherService = cipherService;
    }

    @GetMapping("")
    List<Cipher> findAll(){
        return (List<Cipher>) cipherService.findAll();
    }

    @GetMapping("/{id}")
    Optional<Cipher> findById(@PathVariable Long id){
        return (Optional<Cipher>) cipherService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    void createCipher(@Valid @RequestBody CipherDTO cipherDTO){
        cipherService.createCipher(cipherDTO);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{name}/codebreakers")
    void addCodebreakers(@Valid @RequestBody CodebreakerDTO codebreakerDTO){
        cipherService.addCodebreaker(codebreakerDTO);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        cipherService.delete(id);
    }
}
