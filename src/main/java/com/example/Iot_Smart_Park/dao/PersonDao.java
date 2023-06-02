package com.example.Iot_Smart_Park.dao;

import com.example.Iot_Smart_Park.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int  insertPerson(UUID id, Person person);

    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id,person);
    }

    Optional<Person> selectPersonById(UUID id);
    List<Person> selectAllPersons();
    int deletePersonById(UUID id);
    int updatePersonById(UUID id, Person person);
    Optional<Person> getPersonByName(String name);


}