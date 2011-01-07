package com.personManager.server;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
public interface PersonRepository {
  Person persist(Person person);
}
