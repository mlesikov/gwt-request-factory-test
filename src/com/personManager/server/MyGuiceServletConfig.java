package com.personManager.server;

import com.google.gwt.requestfactory.server.RequestFactoryServlet;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
public class MyGuiceServletConfig extends GuiceServletContextListener {

  @Override
  protected Injector getInjector() {
    GuiceFactory.init(new ServletModule() {
      @Override
      protected void configureServlets() {
        bind(RequestFactoryServlet.class).in(Singleton.class);
        serve("/gwtRequest").with(RequestFactoryServlet.class);

        bind(PersonRepository.class).to(InMemoryPersonRepository.class);
      }
    });
    Injector injector = GuiceFactory.getInjector();
    return injector;
  }
}
