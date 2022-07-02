package com.example.medemo.controller;

import com.example.medemo.dto.AddressDto;
import com.example.medemo.exception.NotFoundException;
import com.example.medemo.mapper.AddressMapper;
import com.example.medemo.model.Address;
import com.example.medemo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping(value="/address")
    List<Address> getAll(){
        return addressService.getAllAddresses();
    }

    @GetMapping(value="/address/{id}")
    ResponseEntity<Address> getById(@PathVariable("id") long id) {
        Address address = addressService.findById(id)
                .orElseThrow(()->new NotFoundException("No Address with ID : "+id));
        return ResponseEntity.ok().body(address);
    }

    @PostMapping(value="/address")
    ResponseEntity<?> createAddress(@RequestBody AddressDto dto) {
        Address address = AddressMapper.DtoToEntity(dto);
        Address addedAddress = addressService.save(address);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedAddress.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/address/{id}")
    ResponseEntity<Address> updateTAddress(@PathVariable("id") long id, @RequestBody AddressDto dto) {
        Address text = addressService.findById(id)
                .orElseThrow(()->new NotFoundException("No Address with ID : "+id));

        Address newAddress = AddressMapper.DtoToEntity(dto);
        newAddress.setId(text.getId());
        addressService.save(newAddress);
        return ResponseEntity.ok().body(newAddress);
    }

    @DeleteMapping(value="/address/{id}")
    ResponseEntity deleteAddress( @PathVariable("id") long id) {
        Address address = addressService.findById(id)
                .orElseThrow(()->new NotFoundException("No Address with ID : "+id));
        addressService.delete(address.getId());
        return ResponseEntity.ok().body("Address with ID : "+id+" deleted with success!");
    }
}
