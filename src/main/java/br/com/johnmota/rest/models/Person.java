package br.com.johnmota.rest.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "persons")
public class Person implements Serializable {
  
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "first_name", nullable = false, length = 150)
  private String firstName;

  @Column(name = "last_name", nullable = false, length = 150)
  private String lastName;

  @Column(nullable = false, length = 100)
  private String addres;

  @Column(nullable = false)
  private String gener;

  @Column(nullable = false, length = 9) 
  private Integer age;

  public Person () {}

  public Long getId() {
    return id;
  }
  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddres() {
    return addres;
  }

  public String getGener() {
    return gener;
  }

  public Integer getAge() {
    return age;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setAddres(String addres) {
    this.addres = addres;
  }

  public void setGener(String gener) {
    this.gener = gener;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
