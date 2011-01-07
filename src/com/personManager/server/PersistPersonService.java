package com.personManager.server;

import com.google.inject.Inject;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
public class PersistPersonService {

  private PersonRepository personRepository;

  @Inject
  public PersistPersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public void persist(Person person){
     personRepository.persist(person);
  }
}
