package com.personManager.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Miroslav Genov (mgenov@gmail.com)
 */
public class GuiceFactory {

  private static final Logger log = Logger.getLogger(GuiceFactory.class.getName());

  private GuiceFactory() {

  }

  private static Injector injector;

  public static void init(Module... modules) {
    long start = System.currentTimeMillis();

    log.info("Injector creation started");

    try {
      injector = Guice.createInjector(Stage.DEVELOPMENT, modules);
    } catch(Exception e) {
      log.info("Initialization failed.");
      log.log(Level.SEVERE, e.getMessage(), e);
    }


    long end = System.currentTimeMillis();

    log.info("Time:" + (end - start) + " ms");

    log.info("Injector created successfully.");

  }

  public static Injector getInjector() {
    return injector;
  }

}

