package com.personManager.server;

import java.util.Date;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
public class PersonService {
  public static Person IN_MEMORY_PERSON = null;

  public Person getPersonPrivateData() {
    Person p = new Person();
    p.setName("Lazo Apostolovski");
    p.setAge(24);
    p.setCreationDate(new Date());
    return p;
  }


  public Person findPersonById(Long id) {
    if (IN_MEMORY_PERSON == null) {
      Person p = new Person();
//      p.setId("1");
      p.setName("Mihail Lesikov");
      p.setAge(25);
      p.setCreationDate(new Date());

      Address address = new Address();
      address.setCity("Tyrnovo");
//      address.setId("1");
      address.setStreet("Bygaria 25");
      address.setZip("5000");

      p.setAddress(address);
      return p;
    } else {
      return IN_MEMORY_PERSON;
    }
  }

  public void persist(Person person) {
    IN_MEMORY_PERSON = person;
    System.out.println(person.toString());
  }
}
