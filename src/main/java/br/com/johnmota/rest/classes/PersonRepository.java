package br.com.johnmota.rest.classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.johnmota.rest.models.Person;

public class PersonRepository {
  private static final String FILENAME = "persons.json";
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static List<Person> getAllPersons() throws IOException {
        try (FileReader reader = new FileReader(FILENAME)) {
            Person[] personsArray = objectMapper.readValue(reader, Person[].class);
            return new ArrayList<>(Arrays.asList(personsArray));
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
  
    }

    public static void saveAllPersons(List<Person> persons) throws IOException {
        try (FileWriter writer = new FileWriter(FILENAME)) {
            objectMapper.writeValue(writer, persons);
        }
    }

    public static Person getPersonById (String id) throws IOException {
        List<Person> persons = getAllPersons();
        for (Person person : persons) {
            if (String.valueOf(person.getId()).equals(id)) {
                return person;
            }
        }
        return null;
    }

    public static boolean deletePersonById(String id) throws IOException {
        List<Person> persons = getAllPersons();
        for (Person person : persons) {
            if (String.valueOf(person.getId()).equals(id)) {
                persons.remove(person);
                saveAllPersons(persons);
                return true; // Retorna true se a pessoa for excluída com sucesso
            }
        }
        return false; // Retorna false se a pessoa não for encontrada
    }
    
  }
