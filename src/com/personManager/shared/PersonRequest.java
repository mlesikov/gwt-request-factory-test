package com.personManager.shared;

import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;
import com.personManager.server.MyServiceLocator;
import com.personManager.server.PersonService;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
@Service(value = PersonService.class, locator = MyServiceLocator.class)
public interface PersonRequest extends RequestContext {

  //  InstanceRequest<PersonPrivateDataProxy,PersonPrivateDataProxy> getPersonPrivateData();
  Request<PersonPrivateDataProxy> getPersonPrivateData();

  Request<PersonProxy> findPersonById(Long id);

  Request<Void> persist(PersonProxy personProxy);

}
