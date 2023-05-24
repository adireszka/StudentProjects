package com.hogwart.gradebook;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hogwart.gradebook.entity.Course;
import com.hogwart.gradebook.entity.JsonFormat.JsonFormattedCharacter;
import com.hogwart.gradebook.entity.Person;
import com.hogwart.gradebook.entity.Spell;
import com.hogwart.gradebook.entity.JsonFormat.JsonFormattedSpell;
import com.hogwart.gradebook.repository.CourseRepository;
import com.hogwart.gradebook.repository.PersonRepository;
import com.hogwart.gradebook.repository.SpellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;

@SpringBootApplication
public class GradebookApplication  implements CommandLineRunner{

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	SpellRepository spellRepository;

	@Autowired
	PersonRepository personRepository;


	public static void main(String[] args) {
		SpringApplication.run(GradebookApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {

		/* FILL UP COURSE TABLE */
		Course[] courses = new Course[]{
			new Course("Charms", "CH104", "In this class, you will learn spells concerned with giving an object new and unexpected properties."),
			new Course("Defence Against the Dark Arts", "DADA", "In this class, you will learn defensive techniques against the dark arts."),
			new Course("Herbology", "HB311", "In this class, you will learn the study of magical plants and how to take care of, utilise and combat them."),
			new Course("History of Magic", "HIS393", "In this class, you will learn about significant events in wizarding history."),
			new Course("Potions", "POT102", "In this class, you will learn correct mixing and stirring of ingredients to create mixtures with magical effects."),
			new Course("Transfiguration", "TR442", "In this class, you will learn the art of changing the form or appearance of an object.")
		};

		if (courseRepository.findById(1L).isEmpty()) {
			for (int i = 0; i < courses.length; i++) {
				courseRepository.save(courses[i]);
			}
		}
		/*	*/

		/* FILL UP SPELL TABLE FROM API*/
		URL spellsUrl = new URL("https://hp-api.onrender.com/api/spells");

		ObjectMapper objectMapper = new ObjectMapper();
		JsonFormattedSpell[] spells = objectMapper.readValue(spellsUrl, new TypeReference<>(){});

		if (spellRepository.findById(1L).isEmpty()) {
			for (JsonFormattedSpell spell : spells) {
				spellRepository.save(new Spell(spell.getName(), spell.getDescription()));
			}
		}
		/*	*/

		/* FILL UP CHARACTER TABLE FROM API*/
		URL charactersUrl = new URL("https://hp-api.onrender.com/api/characters");

		JsonFormattedCharacter[] characters = objectMapper.readValue(charactersUrl, new TypeReference<>(){});

		if (personRepository.findById(1L).isEmpty()){
			for (JsonFormattedCharacter person : characters){
				personRepository.save(new Person(
						person.getName(),
						person.getSpecies(),
						person.getGender(),
						person.getHouse(),
						person.getDateOfBirth(),
						person.getWizard(),
						person.getAncestry(),
						person.getPatronus(),
						person.getHogwartsStudent(),
						person.getHogwartsStaff(),
						person.getImage()
				));
			}
		}
		/*	*/
	}
}
