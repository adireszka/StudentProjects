package com.hogwart.gradebook.repository;

import com.hogwart.gradebook.entity.Person;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findPeopleByHogwartsStudentIsTrue();
    List<Person> findPeopleByHogwartsStaffIsTrue();
    List<Person> findPeopleByHouse(@NonNull String house);
}
