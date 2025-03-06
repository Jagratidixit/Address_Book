package com.example.AddressBook.controller;
import com.example.AddressBook.dto.AddressDTO;
import com.example.AddressBook.model.Address;
import com.example.AddressBook.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressbook")
public class AddressController {
    @Autowired
    private AddressRepo addressRepo;

    @PostMapping("/create")
    public Address create(@RequestBody AddressDTO addressDTO) {
        Address address = new Address();
        address.setName(addressDTO.getName());
        address.setCity(addressDTO.getCity());
        return addressRepo.save(address);
    }


    @GetMapping("/")
    public List<Address> getAll() {
        return addressRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getById(@PathVariable Long id) {
        return addressRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Address> update(@PathVariable Long id, @RequestBody Address newDetails) {
        return addressRepo.findById(id).map(address -> {
            address.setName(newDetails.getName());
            address.setCity(newDetails.getCity());
            return ResponseEntity.ok(addressRepo.save(address));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (addressRepo.existsById(id)) {
            addressRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
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
