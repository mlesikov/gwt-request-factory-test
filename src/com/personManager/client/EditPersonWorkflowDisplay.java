package com.personManager.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.requestfactory.client.RequestFactoryEditorDriver;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.RequestFactory;
import com.personManager.shared.PersonProxy;
import com.personManager.shared.PersonRequest;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
public class EditPersonWorkflowDisplay implements EditPersonWorkflow {


  private Presenter presenter;
  private RequestFactory requestFactory;
  private PersonEditor personEditor;

  // Empty interface declaration, similar to UiBinder
  interface Driver extends RequestFactoryEditorDriver<PersonProxy, PersonEditor> {
  }

  // Create the Driver
  private Driver driver = GWT.create(Driver.class);


  public EditPersonWorkflowDisplay(PersonEditor personEditor, RequestFactory requestFactory) {
    this.personEditor = personEditor;
    this.requestFactory = requestFactory;
  }

  public void edit(PersonProxy personProxy, PersonRequest request) {
       // PersonEditor is a DialogBox that extends Editor<Person>
//    PersonEditor editor = new PersonEditor();
    // Initialize the driver with the top-level editor
    driver.initialize(requestFactory, personEditor);
//    personEditor.editPersonProxy(personProxy);
    // Copy the data in the object into the UI
    driver.edit(personProxy, request);
  }

  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }

  public boolean hasErrors() {
    return driver.hasErrors();
  }

  public RequestContext getPersonRequest() {
    return driver.flush();
  }
}
