package com.personManager.server;

import com.google.gwt.requestfactory.shared.ServiceLocator;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
public class MyServiceLocator implements ServiceLocator {

  public Object getInstance(Class<?> clazz) {

    Object i = GuiceFactory.getInjector().getInstance(clazz);
    return i;
  }
}
