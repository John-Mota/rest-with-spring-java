package br.com.johnmota.rest.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.johnmota.rest.models.Person;
import br.com.johnmota.rest.services.PersonService;
import org.springframework.web.bind.annotation.RequestMethod;


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

}
