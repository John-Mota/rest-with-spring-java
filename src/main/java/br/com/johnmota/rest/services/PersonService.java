package br.com.johnmota.rest.services;


import java.util.List;
import java.util.Optional;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.johnmota.rest.interfaces.PersonRepository;
import br.com.johnmota.rest.models.Person;

@Service
public class PersonService {
  
  private Logger logger = Logger.getLogger(PersonService.class.getName());

  @Autowired
  PersonRepository personRepository;

  public List<Person> getAllPersons() {
    logger.info("Getting all persons");
    return personRepository.findAll();
  }
    
  public Optional<Person> findById(Long id) {
    logger.info("Finding one person");
    return personRepository.findById(id);
  }

  public Person addPerson(Person person) {
    logger.info("Adding a new person");
    return personRepository.save(person);
  }

  public boolean deletePersonById(Long id) {
    logger.info("Deleting person with id: " + id);
    if (personRepository.existsById(id)) {
      personRepository.deleteById(id);
      return true;
    }
    return false;
  }

  public Person updatePerson(Long id, Person person) {
    logger.info("Updating person with id: " + id);
    if (personRepository.existsById(id)) {
      person.setId(id);
      return personRepository.save(person);
    }
    return null; // or throw an exception if person with given id doesn't exist
  }
}