package br.com.johnmota.rest.models;

import java.io.Serializable;

public class Person implements Serializable {
  
  private static final long serialVersionUID = 1L;

  private Long id;
  private String firstName;
  private String lastName;
  private String addres;
  private String gener;
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
