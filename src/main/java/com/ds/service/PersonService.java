package com.ds.service;

import com.ds.domain.Person;
import com.ds.exceptions.PersonNotFoundException;

import java.util.List;

public interface PersonService {
    Person save(Person person);

    Person update(Person person) throws PersonNotFoundException;

    Person findById(Long id) throws PersonNotFoundException;

    List<Person> findAll();

    Person findByName(String personName) throws PersonNotFoundException;
}
