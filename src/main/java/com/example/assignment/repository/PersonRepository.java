package com.example.assignment.repository;

import com.example.assignment.domain.Person;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

    public Person get(Person person){
        return person;
    }
}
