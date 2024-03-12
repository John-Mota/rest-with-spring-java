package br.com.johnmota.rest.classes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.johnmota.rest.models.Person;
import br.com.johnmota.rest.services.PersonService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/person")
public class PersonController {
  
  @Autowired
  private PersonService service;
  
  @RequestMapping(
    value = "/{id}", 
    method=RequestMethod.GET,
    produces = "application/json")
  public Person findById(@PathVariable(value = "id") String id) throws Exception {
      return service.findById(id);
  }

  @RequestMapping(
    value = "/add",
    method = RequestMethod.POST,
    produces = "application/json",
    consumes = "application/json")
  public Person addPerson(@RequestBody Person person) throws Exception {
      return service.addPerson(person.getFirstName(), person.getLastName(), person.getAddres(), person.getGener(), person.getAge());
  }

@RequestMapping(
  value = "/all",
  method = RequestMethod.GET,
  produces = "application/json")
  public List<Person> getAllPersons() throws IOException {
    return service.getAllPersons();
  }

  @RequestMapping(
    value = "/all/{id}",
    method = RequestMethod.GET,
    produces = "application/json")
    public Person getPersonById(@PathVariable(value = "id") String id) throws IOException {
      return service.getPersonById(id);
    }
  
    @RequestMapping(
      value = "/delete/{id}", 
      method = RequestMethod.DELETE)
      public String deletePersonById(@PathVariable String id) throws IOException {
        boolean deleted = service.deletePersonById(id);
        
        if (deleted) {
          return "Person with ID " + id + " deleted successfully.";
        } else {
          return "Person with ID " + id + " not found.";
        }
      }
    
    
}
