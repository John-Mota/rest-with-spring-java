package br.com.johnmota.rest.services;


import java.util.List;
import java.util.Optional;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.johnmota.rest.excepitions.ResourceNotFounExeption;
import br.com.johnmota.rest.interfaces.PersonRepository;
import br.com.johnmota.rest.models.Person;

@Service
public class PersonService {
  
  private Logger logger = Logger.getLogger(PersonService.class.getName());

  @Autowired
  PersonRepository personRepository;

  public List<Person> findAll() {
    logger.info("Getting all persons");
    return personRepository.findAll();
  }
    
  public Optional<Person> findById(Long id) {
    logger.info("Finding one person");
    return personRepository.findById(id);
  }

  @SuppressWarnings("null")
  public Person created(Person person) {
    logger.info("Adding a new person");
    return personRepository.save(person);
  }


  public void deletePersonById(Long id) {
    logger.info("Deleting person with id: " + id);
    try {
        var entity = personRepository.findById(id)
                .orElseThrow();
        personRepository.delete(entity);
    } catch (ResourceNotFounExeption ex) {
        (logger).warning(ex.getMessage());
        throw ex; 
    }
}


  public Person update(Long id, Person person) {
    logger.info("Updating person with id: " + id);
    var entytie = personRepository.findById(person.getId())
      .orElseThrow(() -> new ResourceNotFounExeption("Person not found"));
     entytie.setFirstName(person.getFirstName());
     entytie.setLastName(person.getLastName());
     entytie.setAddres(person.getAddres());
     entytie.setGener(person.getGener());
      return personRepository.save(entytie);
  }
}