package com.personManager.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.personManager.shared.AddressProxy;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
public class AddressEditor extends Composite implements Editor<AddressProxy> {
  interface AddressEditorBinder extends UiBinder<Widget, AddressEditor> {
  }

//  interface Driver extends SimpleBeanEditorDriver<AddressProxy, AddressEditor> {
//  }

  private static AddressEditorBinder uiBinder = GWT.create(AddressEditorBinder.class);

//  private Driver driver;


  @UiField
  ValueBoxEditorDecorator<String> city;


  @UiField
  ValueBoxEditorDecorator<String> street;

  @UiField
  ValueBoxEditorDecorator<String> zip;

  public AddressEditor() {
//    driver = GWT.create(Driver.class);
    initWidget(uiBinder.createAndBindUi(this));
//    initWidget(GWT.<Binder> create(Binder.class).createAndBindUi(this));
  }

//  public void editAddressProxy(AddressProxy addressProxy) {
//    driver.initialize(this);
//    // Copy the data in the object into the UI
//    driver.edit(addressProxy);
//  }
//
//  public AddressProxy getAddressProxy() {
//    return driver.flush();
//  }
}
