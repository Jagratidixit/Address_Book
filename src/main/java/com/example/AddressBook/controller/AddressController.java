package com.example.AddressBook.controller;
import com.example.AddressBook.dto.AddressDTO;
import com.example.AddressBook.model.Address;
import com.example.AddressBook.repository.AddressRepo;
import com.example.AddressBook.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressbook")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/create")
    public Address create(@RequestBody AddressDTO addressDTO) {
        return addressService.create(addressDTO);
    }

    @GetMapping("/")
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getById(@PathVariable Long id) {
        return addressService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

//Create

//curl -X POST -H "Content-Type: application/json" -d '{"name":"John","city":"NY"}' "http://localhost:8080/addressbook/create"
//Get All

//curl http://localhost:8080/addressbook/
//Get by ID

//curl http://localhost:8080/addressbook/1
//Update

//curl -X PUT -H "Content-Type: application/json" -d '{"name":"John Doe","city":"LA"}' "http://localhost:8080/addressbook/update/1"
//Delete

//curl -X DELETE http://localhost:8080/addressbook/delete/1
