package com.personManager.server;

import java.util.Date;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */

public class Person {

  private String name;

  private Address address = new Address();

  private Integer age;

  private Date date;

  public Person() {
  }


  public void setDate(Date date) {
    this.date = date;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public void setCreationDate(Date date) {

    this.date = date;
  }

  public Date getDate() {
    return date;
  }


  public void persist(){
    PersonService.IN_MEMORY_PERSON = this;
    System.out.print("Person was successfully saved\n");
    System.out.print(this.toString()+"\n");
  }

  @Override
  public String toString() {
    return "Person{" +
            "name='" + name + '\'' +
            ", address=" + address +
            ", age=" + age +
            ", date=" + date +
            '}';
  }
}
