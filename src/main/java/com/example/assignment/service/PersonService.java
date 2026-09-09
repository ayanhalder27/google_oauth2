package com.example.assignment.service;

import com.example.assignment.domain.Person;
import com.example.assignment.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person get(Person person){
        return personRepository.get(person);
    }
}
