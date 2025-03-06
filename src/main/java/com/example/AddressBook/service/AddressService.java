package com.example.AddressBook.service;
import com.example.AddressBook.dto.AddressDTO;
import com.example.AddressBook.model.Address;
import com.example.AddressBook.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;

    public Address create(AddressDTO addressDTO) {
        Address address = new Address();
        address.setName(addressDTO.getName());
        address.setCity(addressDTO.getCity());
        return addressRepo.save(address);
    }

    public List<Address> getAll() {
        return addressRepo.findAll();
    }

    public Optional<Address> getById(Long id) {
        return addressRepo.findById(id);
    }
}

