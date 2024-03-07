package com.sanjay.contacts.controller;


import com.sanjay.contacts.model.Contacts;
import com.sanjay.contacts.service.ContactService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactsController {

    @Autowired
    ContactService service;


    @GetMapping("/getAllContacts")
    public ResponseEntity<List<Contacts>> allContacts(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllContacts());
    }


    @PostMapping("/createContact")
    public ResponseEntity<Contacts> createContact(@RequestBody Contacts contact){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createContact(contact));
    }

    @PutMapping("/updateContact/{id}")
    public ResponseEntity<Contacts> updateContact(@PathVariable ObjectId id, @RequestBody Contacts contact){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.updateContact(id,contact));
    }

    @DeleteMapping("/deleteContact/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable ObjectId id)
    {
        service.deteleContact(id);
        return  ResponseEntity.status(HttpStatus.OK).body("Contact Deleted");
    }

}
