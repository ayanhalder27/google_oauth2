package com.example.assignment.api;

import com.example.assignment.domain.Person;
import com.example.assignment.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/person")
public class PersonApi {
    PersonService personService;

    public PersonApi(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<Person> get(Person person){
        return ResponseEntity.ok(person);
    }
}
