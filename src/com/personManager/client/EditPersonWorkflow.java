package com.personManager.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.requestfactory.client.RequestFactoryEditorDriver;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.RequestFactory;
import com.personManager.shared.PersonProxy;
import com.personManager.shared.PersonRequest;
import com.personManager.shared.PersonRequestFactory;


/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
public class EditPersonWorkflow {
  private PersonEditor personEditor;
  private RequestFactory requestFactory;


  // Empty interface declaration, similar to UiBinder
  interface Driver extends RequestFactoryEditorDriver<PersonProxy, PersonEditor> {
  }

  // Create the Driver
  private Driver driver = GWT.create(Driver.class);

  public EditPersonWorkflow(PersonEditor personEditor, PersonRequestFactory requestFactory) {
    this.personEditor = personEditor;
    this.requestFactory = requestFactory;
  }

  void edit(PersonProxy p, RequestContext requestContext) {
    // PersonEditor is a DialogBox that extends Editor<Person>
//    PersonEditor editor = new PersonEditor();
    // Initialize the driver with the top-level editor
    driver.initialize(requestFactory, personEditor);
    // Copy the data in the object into the UI
    driver.edit(p, requestContext);
  }

  // Called by some UI action
  void save() {
    PersonRequest requestContext = (PersonRequest) driver.flush();

//    if (driver.hasErrors()) {
      // A sub-editor reported errors
//    }

    requestContext.persist(personEditor.getPersonProxy()).fire(new Receiver<Void>() {
      @Override
      public void onSuccess(Void response) {
        GWT.log("successfully saved");
      }
    });


  }

}
