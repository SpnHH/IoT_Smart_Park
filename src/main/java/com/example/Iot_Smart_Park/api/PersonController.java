package com.example.Iot_Smart_Park.api;

import com.example.Iot_Smart_Park.model.Person;
import com.example.Iot_Smart_Park.service.PersonService;
import com.example.Iot_Smart_Park.utils.JsonUtils;
import io.micrometer.common.lang.NonNull;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "{username}")
    public Optional<Person> getPersonByUsername(@PathVariable("username") String username) {
        return personService.getPersonByName(username);
    }

    @PostMapping
    public String getAuth(@RequestBody String personStr) {
        JSONObject jsonObject = JsonUtils.stringToJson(personStr);
        Optional<Person> userDB = personService.getPersonByName(jsonObject.get("username").toString());
        if(userDB.isEmpty()){
            return "User does not exist";
        }
        if(jsonObject.get("pass").toString().equals(userDB.get().getPass().toString())){
            return "Success";
        }else {
            return "Password does not match";
        }
    }

    @PostMapping("/newPerson")
    public String addPerson(@NonNull @RequestBody String personStr){
        JSONObject jsonObject = JsonUtils.stringToJson(personStr);
        Person person = new Person(UUID.randomUUID(),jsonObject.get("username").toString(), jsonObject.get("pass").toString());
        if(personService.getPersonByName(person.getUsername()).isEmpty()) {
            personService.addPerson(person);
            return "Success";
        }else{
            return "username not available";
        }
    }
}