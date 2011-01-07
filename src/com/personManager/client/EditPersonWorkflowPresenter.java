package com.personManager.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.personManager.shared.PersonProxy;
import com.personManager.shared.PersonRequest;
import com.personManager.shared.PersonRequestFactory;


/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
public class EditPersonWorkflowPresenter implements EditPersonWorkflow.Presenter{
  private PersonRequestFactory requestFactory;
  private PersonProxy personProxy;
  private EditPersonWorkflow display;

  public EditPersonWorkflowPresenter(PersonRequestFactory requestFactory, PersonProxy personProxy) {
    this.requestFactory = requestFactory;
    this.personProxy = personProxy;
  }

  public void bindDisplay(EditPersonWorkflow display){
    this.display = display;
    display.setPresenter(this);
  }


  public void edit(PersonRequest request) {
    request.persist(personProxy);
    display.edit(personProxy,request);
  }

  // Called by some UI action
  public void onSave() {
    final RequestContext requestContext = display.getPersonRequest();

    if (!display.hasErrors()) {
      // A sub-editor reported errors

      requestContext.fire(new Receiver<Void>() {
        @Override
        public void onSuccess(Void response) {
          GWT.log("successfully saved");
//          personProxy = requestFactory.getPersonRequest().create(PersonProxy.class);
//          AddressProxy address = requestContext.create(AddressProxy.class);
//          PersonProxy person = requestContext.create(PersonProxy.class);
//          person.setAddress(address);
//          personProxy = person;
//          personProxy = personEditor.getPersonProxy();
//          personProxy = null;
          edit(requestFactory.getPersonRequest());
        }
      });
    }

  }

}
