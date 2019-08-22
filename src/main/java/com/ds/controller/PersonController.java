package com.ds.controller;

import com.ds.domain.Person;
import com.ds.exceptions.PersonNotFoundException;
import com.ds.exceptions.WrongPrimaryKeysException;
import com.ds.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    public Person post(@RequestBody Person person){
        return service.save(person);
    }

    @PutMapping(value = "/{id}")
    public Person put(@PathVariable("id") Long id, Person person) throws WrongPrimaryKeysException, PersonNotFoundException {
        final Person updatedPerson = service.update(id, person);
        return updatedPerson;
    }

    @GetMapping(value = "/{id}")
    public Person get(@PathVariable("id") Long id) throws PersonNotFoundException {
        return service.findById(id);
    }

    @DeleteMapping()
    public void delete(@RequestBody Person person){
        service.delete(person);
    }
}
