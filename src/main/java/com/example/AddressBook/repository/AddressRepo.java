package com.example.AddressBook.repository;
import com.example.AddressBook.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> { }
