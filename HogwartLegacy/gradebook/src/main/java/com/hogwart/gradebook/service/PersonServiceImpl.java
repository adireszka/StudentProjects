package com.hogwart.gradebook.service;

import com.hogwart.gradebook.entity.Person;
import com.hogwart.gradebook.exception.PersonNotFoundException;
import com.hogwart.gradebook.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PersonServiceImpl implements PersonService{

    PersonRepository personRepository;

    @Override
    public Person getPerson(Long id) {
        Optional<Person> person = personRepository.findById(id);
        return unwrapPerson(person, id);
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public List<Person> getPersons() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public List<Person> getStudents() {
        return personRepository.findPeopleByHogwartsStudentIsTrue();
    }

    @Override
    public List<Person> getStaff() {
        return personRepository.findPeopleByHogwartsStaffIsTrue();
    }

    @Override
    public List<Person> getHouseStudents(String house) {
        return personRepository.findPeopleByHouse(house);
    }

    static Person unwrapPerson(Optional<Person> person, Long id){
        if (person.isPresent()) return person.get();
        else throw new PersonNotFoundException(id);
    }
}
