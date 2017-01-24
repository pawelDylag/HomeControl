package com.paweldylag.homecontrol.view;

import com.paweldylag.homecontrol.app.exception.LoginException;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public interface LoginView {

  void showEmptyLogin();

  void showEmptyPassword();

  void showWrongPassword();

  void proceedWithLogin();

  void showProgress(boolean show);

  void showError(LoginException e);
}
