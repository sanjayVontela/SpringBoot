package com.sanjay.contacts.dao;

import com.sanjay.contacts.model.Contacts;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactsRepository extends MongoRepository<Contacts, ObjectId> {
}
