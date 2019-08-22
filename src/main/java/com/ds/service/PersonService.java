package com.ds.service;

import com.ds.domain.Person;
import com.ds.exceptions.PersonNotFoundException;
import com.ds.exceptions.WrongPrimaryKeysException;

import java.util.List;

public interface PersonService {
    Person save(Person person);

    Person update(Long id, Person person) throws PersonNotFoundException, WrongPrimaryKeysException;

    Person findById(Long id) throws PersonNotFoundException;

    List<Person> findAll();

    Person findByName(String personName) throws PersonNotFoundException;

    void delete(Person person);
}
