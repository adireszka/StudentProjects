package com.hogwart.gradebook.service;

import com.hogwart.gradebook.entity.Person;

import java.util.List;

public interface PersonService {
    Person getPerson(Long id);
    Person savePerson(Person person);
    void deletePerson(Long id);
    List<Person> getPersons();
    List<Person> getStudents();
    List<Person> getStaff();
    List<Person> getHouseStudents(String house);
}
