package com.example.assignment.api;

import com.example.assignment.domain.Person;
import com.example.assignment.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
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
    public ResponseEntity<Person> get(@AuthenticationPrincipal OAuth2User user){
        return ResponseEntity.ok(personService.get(user));
    }
}
