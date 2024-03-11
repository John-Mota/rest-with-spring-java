package br.com.johnmota.rest.services;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.johnmota.rest.classes.PersonRepository;
import br.com.johnmota.rest.models.Person;

@Service
public class PersonService {
  
  private final AtomicLong counter = new AtomicLong();
  private Logger logger = Logger.getLogger(PersonService.class.getName());

  public List<Person> getAllPersons() throws IOException {
        return PersonRepository.getAllPersons();
    }
  public Person findById(String id) {

    logger.info("Finding one person");
    Person person = new Person();
    person.setId(counter.incrementAndGet());
    person.setFirstName("John");
    person.setLastName("Mota");
    person.setAddres("Fortaleza - Ceara");
    person.setGener("Masculino");
    person.setAge(32);
    return person;
  }

  public Person addPerson(String firstName, String lastName, String address, String gender, int age) throws IOException {
    logger.info("Adding a new person");
    List<Person> persons = PersonRepository.getAllPersons();
    Person newPerson = new Person();
    newPerson.setId(counter.incrementAndGet());
    newPerson.setFirstName(firstName);
    newPerson.setLastName(lastName);
    newPerson.setAddres(address);
    newPerson.setGener(gender);
    newPerson.setAge(age);
    persons.add(newPerson);
    PersonRepository.saveAllPersons(persons);
    return newPerson;
}
}