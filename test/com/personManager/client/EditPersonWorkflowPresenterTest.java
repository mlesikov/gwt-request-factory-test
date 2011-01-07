package com.personManager.client;

import com.google.gwt.requestfactory.shared.BaseProxy;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.personManager.shared.AddressProxy;
import com.personManager.shared.PersonPrivateDataProxy;
import com.personManager.shared.PersonProxy;
import com.personManager.shared.PersonRequest;
import com.personManager.shared.PersonRequestFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static org.easymock.EasyMock.*;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
public class EditPersonWorkflowPresenterTest {


  private EditPersonWorkflow.Presenter presenter;

  private StubEditPersonWorkflowDisplay display;

  private PersonRequestFactory requestFactory;

  @Before
  public void setUp() throws Exception {

    requestFactory = createMock(PersonRequestFactory.class);

    display = new StubEditPersonWorkflowDisplay();


  }

  private void initializeWorkFlow(PersonProxy personProxy) {
    presenter = new EditPersonWorkflowPresenter(requestFactory, personProxy);
    presenter.bindDisplay(display);
  }

  @Test
  public void testEditPerson() throws Exception {

    PersonProxy personProxy = getTestPerson();
    initializeWorkFlow(personProxy);

    StubPersonRequest request = new StubPersonRequest();

    presenter.edit(request);

    assertEquals(request, display.request);
    assertEquals(personProxy, request.persistedPersonProxy);
    assertEquals(personProxy, display.personProxy);
  }

  @Test
  public void testSendRequest() throws Exception {

    PersonProxy personProxy = getTestPerson();
    initializeWorkFlow(personProxy);

    StubPersonRequest request = new StubPersonRequest();
    display.request = request;


    StubPersonRequest nextRequest = new StubPersonRequest();
    expect(requestFactory.getPersonRequest()).andReturn(nextRequest);

    replay(requestFactory);
    presenter.onSave();

    request.receiver.onSuccess(null);

    //edit(..) has been called
    assertEquals(nextRequest, display.request);
    assertEquals(personProxy, nextRequest.persistedPersonProxy);
    assertEquals(personProxy, display.personProxy);
    verify(requestFactory);
  }

  private PersonProxy getTestPerson() {
    PersonProxyImpl personProxy = new PersonProxyImpl();

    return personProxy;
  }

  private class PersonProxyImpl implements PersonProxy {

    private String name;

    public Date getDate() {
      return null;
    }

    public void setDate(Date date) {
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public Integer getAge() {
      return null;
    }

    public void setAge(Integer age) {
    }

    public AddressProxy getAddress() {
      return null;
    }

    public void setAddress(AddressProxy address) {
    }

  }

  private class StubEditPersonWorkflowDisplay implements EditPersonWorkflow {


    public boolean hasErrors = false;
    public PersonProxy personProxy;
    public PersonRequest request;

    public void edit(PersonProxy personProxy, PersonRequest request) {
      this.personProxy = personProxy;
      this.request = request;
    }

    public void setPresenter(Presenter presenter) {
    }

    public boolean hasErrors() {
      return hasErrors;
    }

    public RequestContext getPersonRequest() {
      return request;
    }

  }

  private class StubPersonRequest implements PersonRequest {
    private PersonProxyImpl editedProxy;
    private PersonProxy persistedPersonProxy;
    private Receiver<Void> receiver;

    public Request<PersonPrivateDataProxy> getPersonPrivateData() {
      return null;
    }

    public Request<PersonProxy> findPersonById(Long id) {
      return null;
    }

    public Request<Void> persist(PersonProxy personProxy) {
      persistedPersonProxy = personProxy;
      return null;
    }

    public <T extends BaseProxy> T create(Class<T> clazz) {
      return null;
    }

    public <T extends BaseProxy> T edit(T object) {
      this.editedProxy = (PersonProxyImpl) object;
      return object;
    }

    public void fire() {
    }

    public void fire(Receiver<Void> receiver) {
      this.receiver = receiver;
    }

    public boolean isChanged() {
      return false;
    }
  }
}
