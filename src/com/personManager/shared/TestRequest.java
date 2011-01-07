package com.personManager.shared;

import com.google.gwt.requestfactory.shared.InstanceRequest;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;
import com.personManager.server.Person;


/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
@Service(value = Person.class)
public interface TestRequest extends RequestContext{

   InstanceRequest<PersonProxy,Void> persist();
}
