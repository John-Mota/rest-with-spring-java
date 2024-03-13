package br.com.johnmota.rest.interfaces;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import br.com.johnmota.rest.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}


    
  
