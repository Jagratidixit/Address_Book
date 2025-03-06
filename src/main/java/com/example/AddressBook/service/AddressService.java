package com.example.AddressBook.service;

import com.example.AddressBook.dto.AddressDTO;
import com.example.AddressBook.model.Address;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final List<Address> addressList = new ArrayList<>();
    private long idCounter = 1;

    public Address create(AddressDTO addressDTO) {
        Address address = new Address(idCounter++, addressDTO.getName(), addressDTO.getCity());
        addressList.add(address);
        return address;
    }

    public List<Address> getAll() {
        return addressList;
    }

    public Optional<Address> getById(Long id) {
        return addressList.stream().filter(address -> address.getId().equals(id)).findFirst();
    }
}
