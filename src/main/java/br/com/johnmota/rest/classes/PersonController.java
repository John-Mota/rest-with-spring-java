package br.com.johnmota.rest.classes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.johnmota.rest.excepitions.ResourceNotFounExeption;
import br.com.johnmota.rest.models.Person;
import br.com.johnmota.rest.services.PersonService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/person")
public class PersonController {
  
  @Autowired
  private PersonService service;
  
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Person> findAll() {
    return service.findAll();
  }
  
  
  @PostMapping(
    value = "/add",
    produces = "application/json")
  public Person created(@RequestBody Person person) throws Exception {
      return service.created(person);
  }



  @GetMapping(
    value = "/{id}",
    produces = "application/json")
  public Person getPersonById(@PathVariable(value = "id") Long id) throws IOException {
    return service.findById(id).orElseThrow(() -> new ResourceNotFounExeption("Person not found"));
  }
  
  @DeleteMapping(
    value = "/delete/{id}")
  public ResponseEntity<?> deletePersonById(@PathVariable Long id) {
    try {
        service.deletePersonById(id);
        return ResponseEntity.noContent().build();
    } catch (ResourceNotFounExeption e) {
        return ResponseEntity.notFound().build();
    }
}

  @PutMapping(
    value = "/update/{id}",
    produces = "application/json")
  public Person updatePerson(@PathVariable Long id, @RequestBody Person person) throws IOException {
    return service.update(id, person);
  }
}
