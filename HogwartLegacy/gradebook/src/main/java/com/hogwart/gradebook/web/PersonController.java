package com.hogwart.gradebook.web;

import com.hogwart.gradebook.entity.Person;
import com.hogwart.gradebook.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {

    PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id){
        return new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> savePerson(@RequestBody Person person){
        return new ResponseEntity<>(personService.savePerson(person), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getPersons(){
        return new ResponseEntity<>(personService.getPersons(), HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Person>> getStudents(){
        return new ResponseEntity<>(personService.getStudents(), HttpStatus.OK);
    }

    @GetMapping("/staff")
    public ResponseEntity<List<Person>> getStaff(){
        return new ResponseEntity<>(personService.getStaff(), HttpStatus.OK);
    }

    @GetMapping("/house/{house}")
    public ResponseEntity<List<Person>> getHouseStudents(@PathVariable String house){
        return new ResponseEntity<>(personService.getHouseStudents(house), HttpStatus.OK);
    }
}
