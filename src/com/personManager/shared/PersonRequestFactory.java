package com.personManager.shared;

import com.google.gwt.requestfactory.shared.RequestFactory;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
public interface PersonRequestFactory extends RequestFactory {

  PersonRequest getPersonRequest();

  PersistPersonRequest getPersistPersonRequest();

  TestRequest getTestRequest();
}
