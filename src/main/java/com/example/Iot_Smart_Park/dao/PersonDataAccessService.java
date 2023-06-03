package com.example.Iot_Smart_Park.dao;

import com.example.Iot_Smart_Park.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository("personPostgres")
public class PersonDataAccessService implements PersonDao{

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        final String sql = "INSERT INTO person (id, username, pass)" + "VALUES(?,?,?)";
        jdbcTemplate.update(sql, id, person.getUsername(), person.getPass());
        return 1;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        for(Person person: selectAllPersons()){
            if(person.getId().equals(id)){
                return Optional.ofNullable(person);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Person> selectAllPersons() {
        final  String sql = "SELECT id, username, pass FROM person";
        return jdbcTemplate.query(sql, new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                var id = UUID.fromString(rs.getString("id"));
                var username = rs.getString("username");
                var pass = rs.getString("pass");
                return new Person(id,username, pass);
            }
        });

    }

    @Override
    public int deletePersonById(UUID id) {
        final String sql = "DELETE FROM person WHERE id=?";
        jdbcTemplate.update(sql, id);
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        String sql = "Update person SET username = ? WHERE id = ?";
        return jdbcTemplate.update(sql, person.getUsername(), id);
    }

    @Override
    public Optional<Person> getPersonByName(String name) {
        List<Person> personList = new ArrayList<>();
        personList = selectAllPersons();
        for(Person person: personList){
            if(person.getUsername().toLowerCase(Locale.ROOT).equals(name.toLowerCase(Locale.ROOT))){
                return Optional.ofNullable(person);
            }
        }
        return Optional.empty();
    }
}
