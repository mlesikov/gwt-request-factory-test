package com.personManager.shared;

import com.google.gwt.requestfactory.shared.ProxyFor;
import com.google.gwt.requestfactory.shared.ValueProxy;
import com.personManager.server.Address;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
@ProxyFor(Address.class)
public interface AddressProxy extends ValueProxy {

//  String getId();
//
//  void setId(String id);

  String getCity();

  void setCity(String city);

  String getStreet();

  void setStreet(String street);

  String getZip();

  void setZip(String zip);
}
