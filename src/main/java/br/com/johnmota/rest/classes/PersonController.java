package br.com.johnmota.rest.classes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.johnmota.rest.models.Person;
import br.com.johnmota.rest.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
  
  @Autowired
  private PersonService service;
  
  @RequestMapping(
    value = "/add",
    method = RequestMethod.POST,
    produces = "application/json",
    consumes = "application/json")
  public Person addPerson(@RequestBody Person person) throws Exception {
      return service.addPerson(person);
  }

  @RequestMapping(
    method = RequestMethod.GET,
    produces = "application/json")
  public List<Person> getAllPersons() throws IOException {
    return service.getAllPersons();
  }

  @RequestMapping(
    value = "/{id}",
    method = RequestMethod.GET,
    produces = "application/json")
  public Person getPersonById(@PathVariable(value = "id") Long id) throws IOException {
    return service.findById(id).orElse(null);
  }
  
  @RequestMapping(
    value = "/delete/{id}", 
    method = RequestMethod.DELETE)
  public String deletePersonById(@PathVariable Long id) throws IOException {
    boolean deleted = service.deletePersonById(id);
    
    if (deleted) {
      return "Person with ID " + id + " deleted successfully.";
    } else {
      return "Person with ID " + id + " not found.";
    }
  }

  @RequestMapping(
    value = "/update/{id}",
    method = RequestMethod.PUT,
    produces = "application/json",
    consumes = "application/json")
  public Person updatePerson(@PathVariable Long id, @RequestBody Person person) throws IOException {
    return service.updatePerson(id, person);
  }
}
