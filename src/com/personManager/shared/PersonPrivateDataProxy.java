package com.personManager.shared;

import com.google.gwt.requestfactory.shared.ProxyFor;
import com.google.gwt.requestfactory.shared.ValueProxy;
import com.personManager.server.Person;

import java.util.Date;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
@ProxyFor(value = Person.class)
public interface PersonPrivateDataProxy extends ValueProxy {

  Date getDate();

  String getName();

  Integer getAge();

}
