package com.ds.service;

import com.ds.domain.Person;
import com.ds.exceptions.WrongPrimaryKeysException;
import com.ds.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import com.ds.exceptions.PersonNotFoundException;

@Service
public class PersonServiceImpl implements PersonService{
    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person update(Long id, Person person) throws PersonNotFoundException, WrongPrimaryKeysException {
        Optional<Person> optionalPerson = Optional.ofNullable(personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException()));

        if(!Objects.equals(id, person.getId())){
           throw  new WrongPrimaryKeysException();
        }

        Person personToUpdate = optionalPerson.get();
        personToUpdate.setAge(person.getAge());
        personToUpdate.setCity(person.getCity());
        personToUpdate.setName(person.getName());

        return personRepository.save(personToUpdate);
    }

    @Override
    public Person findById(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException());
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findByName(String personName) throws PersonNotFoundException {
        return personRepository.findByName(personName).orElseThrow(() -> new PersonNotFoundException());
    }

    @Override
    public void delete(Person person) {
        personRepository.delete(person);
    }
}
