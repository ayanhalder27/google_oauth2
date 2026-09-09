package com.example.assignment.repository;

import com.example.assignment.domain.Person;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

    public Person get(OAuth2User user){
        return new Person(user.getAttribute("name"), user.getAttribute("email"));
    }
}
