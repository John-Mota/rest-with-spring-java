package br.com.johnmota.rest.services;

import java.util.concurrent.atomic.AtomicLong;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.johnmota.rest.models.Person;

@Service
public class PersonService {
  
  private final AtomicLong counter = new AtomicLong();
  private Logger logger = Logger.getLogger(PersonService.class.getName());

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
}