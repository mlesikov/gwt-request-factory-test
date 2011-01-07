package com.personManager.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.personManager.shared.PersistPersonRequest;
import com.personManager.shared.PersonPrivateDataProxy;
import com.personManager.shared.PersonProxy;
import com.personManager.shared.PersonRequest;
import com.personManager.shared.PersonRequestFactory;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class PersonManager implements EntryPoint {
  private Label label = new Label();
  final EventBus eventBus = new SimpleEventBus();
  final Button button = new Button("Click me");
  final Button findPersonButton = new Button("find person");
  final Button savePersonButton = new Button("save person");
  PersonRequestFactory requestFactory;
  PersonRequest personRequest;
  PersistPersonRequest persistPersonRequest;
  PersonEditor personEditor = new PersonEditor();
  PersonProxy personProxy;

  private PersonRequest editPersonRequest;


  private EditPersonWorkflow editPersonWorkflow;

  public void onModuleLoad() {

    initilaizePersonRequest();


    findPersonButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
//        PersonRequest personRequest = requestFactory.getPersonRequest();
//        final PersonProxy person = personRequest.create(PersonProxy.class);
//        person.setId("1");
//        requestFactory.find(person.stableId()).fire(new Receiver<Object>() {
//          @Override
//          public void onSuccess(Object response) {
//            personProxy = person;
//
//          }
//        });


        final PersonRequest request = requestFactory.getPersonRequest();
        request.findPersonById(1l).fire(new Receiver<PersonProxy>() {
          @Override
          public void onSuccess(PersonProxy response) {
//            personProxy = response;
//            editPersonRequest = requestFactory.getPersonRequest();
//
//            personEditor.editPersonProxy(editPersonRequest.edit(personProxy));
            editPersonWorkflow = new EditPersonWorkflow(personEditor,requestFactory,response);
            editPersonWorkflow.edit(requestFactory.getPersonRequest());
          }
        });
      }
    });


    savePersonButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {

        editPersonWorkflow.save();

//        personProxy = personEditor.getPersonProxy();
//
//        editPersonRequest.persist(personProxy).fire(new Receiver<Void>() {
//          @Override
//          public void onSuccess(Void response) {
//            label.setText("person successfully saved! ");
//          }
//        });


////        requestFactory.getTestRequest().edit(personProxy);
//        requestFactory.getTestRequest().persist().using(personProxy).with("age").fire(new Receiver<Void>() {
//          @Override
//          public void onSuccess(Void response) {
//                label.setText("person successfully saved! ");
//          }
//        });
      }
    });


    addButtonClickHandler();


    // Assume that the host HTML has elements defined whose
    // IDs are "slot1", "slot2".  In a real app, you probably would not want
    // to hard-code IDs.  Instead, you could, for example, search for all
    // elements with a particular CSS class and replace them with widgets.
    //
    RootPanel.get("slot1").add(button);
    RootPanel.get("slot2").add(label);
    RootPanel.get("slot2").add(personEditor);
    RootPanel.get("slot2").add(findPersonButton);
    RootPanel.get("slot2").add(savePersonButton);
  }

  private void initilaizePersonRequest() {
    requestFactory = GWT.create(PersonRequestFactory.class);
    requestFactory.initialize(eventBus);
//    personRequest = requestFactory.getPersonRequest();
//    persistPersonRequest = requestFactory.getPersistPersonRequest();
  }

  private void addButtonClickHandler() {
    button.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {


        requestFactory.getPersonRequest().getPersonPrivateData().to(new Receiver<PersonPrivateDataProxy>() {
          @Override
          public void onSuccess(PersonPrivateDataProxy response) {
            label.setText("Person: " + response.getName() + " age:" + response.getAge() + " date of the response:" + response.getDate().toString());
          }
        }).fire();

      }
    });

  }


}
