package com.personManager.shared;


import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;
import com.personManager.server.MyServiceLocator;
import com.personManager.server.PersistPersonService;


/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */

@Service(value = PersistPersonService.class,locator = MyServiceLocator.class)
public interface PersistPersonRequest extends RequestContext {

    Request<Void> persist(PersonProxy personProxy);


}
