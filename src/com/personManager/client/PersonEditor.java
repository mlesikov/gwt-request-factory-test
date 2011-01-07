package com.personManager.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.personManager.shared.PersonProxy;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
public class PersonEditor extends Composite implements Editor<PersonProxy> {
  interface PersonEditorBinder extends UiBinder<Widget, PersonEditor> {

  }

  interface Driver extends SimpleBeanEditorDriver<PersonProxy, PersonEditor> {

  }

  private static PersonEditorBinder uiBinder = GWT.create(PersonEditorBinder.class);

  private Driver driver;

  @UiField
  public ValueBoxEditorDecorator<String> name;

  @UiField
  public ValueBoxEditorDecorator<Integer> age;

  @UiField
  public AddressEditor address;

  public PersonEditor() {
    driver = GWT.create(Driver.class);
    initWidget(uiBinder.createAndBindUi(this));
  }

  public void editPersonProxy(PersonProxy personProxy) {
    driver.initialize(this);
    // Copy the data in the object into the UI
    driver.edit(personProxy);
  }

  public PersonProxy getPersonProxy() {
    return driver.flush();
  }

  //  public ValueBoxEditorDecorator<Date> date;
  public void clear() {
    driver.initialize(this);
  }
}