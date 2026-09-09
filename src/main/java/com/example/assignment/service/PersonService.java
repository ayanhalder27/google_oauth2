package com.example.assignment.service;

import com.example.assignment.domain.Person;
import com.example.assignment.repository.PersonRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person get(OAuth2User user){
        return personRepository.get(user);
    }
}
