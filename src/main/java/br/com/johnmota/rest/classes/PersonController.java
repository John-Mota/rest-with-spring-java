package br.com.johnmota.rest.classes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.johnmota.rest.excepitions.ResourceNotFounExeption;
import br.com.johnmota.rest.models.Person;
import br.com.johnmota.rest.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
  
  @Autowired
  private PersonService service;
  
  @RequestMapping(
    method = RequestMethod.GET,
    produces = "application/json")
  public List<Person> findAll() {
    return service.findAll();
  }
  @RequestMapping(
    value = "/add",
    method = RequestMethod.POST,
    produces = "application/json",
    consumes = "application/json")
  public Person created(@RequestBody Person person) throws Exception {
      return service.created(person);
  }



  @RequestMapping(
    value = "/{id}",
    method = RequestMethod.GET,
    produces = "application/json")
  public Person getPersonById(@PathVariable(value = "id") Long id) throws IOException {
    return service.findById(id).orElseThrow(() -> new ResourceNotFounExeption("Person not found"));
  }
  
  @RequestMapping(
    value = "/delete/{id}", 
    method = RequestMethod.DELETE)
  public ResponseEntity<String> deletePersonById(@PathVariable Long id) {
    try {
        service.deletePersonById(id);
        return ResponseEntity.ok("Person with ID " + id + " deleted successfully.");
    } catch (ResourceNotFounExeption e) {
        return ResponseEntity.notFound().build();
    }
}

  @RequestMapping(
    value = "/update/{id}",
    method = RequestMethod.PUT,
    produces = "application/json",
    consumes = "application/json")
  public Person updatePerson(@PathVariable Long id, @RequestBody Person person) throws IOException {
    return service.update(id, person);
  }
}
