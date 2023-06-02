package com.example.Iot_Smart_Park.api;

import com.example.Iot_Smart_Park.model.Person;
import com.example.Iot_Smart_Park.service.PersonService;
import io.micrometer.common.lang.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @PostMapping
    public void addPerson(@NonNull @RequestBody Person person){
        if(personService.getPersonByName(person.getUsername()).isEmpty()) {
            personService.addPerson(person);
        }
    }
}