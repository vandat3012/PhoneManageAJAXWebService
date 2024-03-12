package com.example.phonemanameajaxwebservice.controller;

import com.example.phonemanameajaxwebservice.model.SmartPhone;
import com.example.phonemanameajaxwebservice.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/smartphones")
@CrossOrigin("*")
public class SmartPhoneController {
    @Autowired
    private ISmartPhoneService iSmartPhoneService;

    @GetMapping
    public ResponseEntity<Iterable<SmartPhone>> showList() {
        Iterable<SmartPhone> smartPhones = iSmartPhoneService.findAll();
        return new ResponseEntity<>(smartPhones, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SmartPhone> findById(@PathVariable Long id) {
        Optional<SmartPhone> smartPhone = iSmartPhoneService.findById(id);
        return new ResponseEntity<>(smartPhone.get(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<SmartPhone> save (@RequestBody SmartPhone smartPhone) {
        return new ResponseEntity<>(iSmartPhoneService.save(smartPhone),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<SmartPhone> edit (@PathVariable Long id,@RequestBody SmartPhone smartPhone) {
        Optional<SmartPhone> smartPhoneOptional = iSmartPhoneService.findById(id);
        smartPhone.setId(smartPhoneOptional.get().getId());
        return new ResponseEntity<>(iSmartPhoneService.save(smartPhone),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> delete (@PathVariable Long id){
        Optional<SmartPhone> smartPhoneOptional = iSmartPhoneService.findById(id);
        iSmartPhoneService.remove(id);
        return new ResponseEntity<>(smartPhoneOptional.get(),HttpStatus.OK);
    }
}
