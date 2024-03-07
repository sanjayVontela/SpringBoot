package com.sanjay.contacts.service;

import com.sanjay.contacts.dao.ContactsRepository;
import com.sanjay.contacts.model.Contacts;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    ContactsRepository contactsRepository;

    @Autowired
    MongoTemplate mongoTemplate;
    public List<Contacts> getAllContacts(){
        return contactsRepository.findAll();
    }

    public Contacts createContact(Contacts contact){
        return contactsRepository.save(contact);
    }

    public Contacts updateContact(ObjectId id,Contacts contact){

        Optional<Contacts> existingItem = contactsRepository.findById(id);
        if(existingItem.isPresent()){
            Contacts con = existingItem.get();
            con.setfName(contact.getfName());
            con.setlName(contact.getlName());
            con.setCompany(contact.getCompany());
            con.setpNumbers(contact.getpNumbers());
            con.setLabels(contact.getLabels());
            con.setBirthday(contact.getBirthday());
            return contactsRepository.save(con);
        }
        else{
            Contacts c = null;
            return c;
        }

    }

    public void deteleContact(ObjectId id){

        contactsRepository.deleteById(id);
    }
}
