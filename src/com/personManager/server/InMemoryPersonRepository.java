package com.personManager.server;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
public class InMemoryPersonRepository implements PersonRepository {
  public Person persist(Person person) {
    System.out.print("Person was successfully saved\n");
    System.out.print(person.toString()+"\n");
    PersonService.IN_MEMORY_PERSON = person;
    return person;
  }
}
