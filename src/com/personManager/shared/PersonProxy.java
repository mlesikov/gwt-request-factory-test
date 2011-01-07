package com.personManager.shared;

import com.google.gwt.requestfactory.shared.ProxyFor;
import com.google.gwt.requestfactory.shared.ValueProxy;
import com.personManager.server.Person;

import java.util.Date;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
@ProxyFor(value = Person.class)
//public interface PersonProxy extends EntityProxy {
public interface PersonProxy extends ValueProxy {


  Date getDate();

  void setDate(Date date);

  String getName();

  void setName(String name);

  Integer getAge();

  void setAge(Integer age);

  AddressProxy getAddress();

  void setAddress(AddressProxy address);

}
