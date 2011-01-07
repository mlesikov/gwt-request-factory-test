package com.personManager.client;

import com.google.gwt.requestfactory.shared.RequestContext;
import com.personManager.shared.PersonProxy;
import com.personManager.shared.PersonRequest;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
public interface EditPersonWorkflow {

  public interface Presenter {

    public void bindDisplay(EditPersonWorkflow display);

    void edit(PersonRequest request);

    void onSave();

  }

  void edit(PersonProxy personProxy, PersonRequest request);

  void setPresenter(Presenter editPersonWorkflowPresenter);

  boolean hasErrors();

  RequestContext getPersonRequest();
}
