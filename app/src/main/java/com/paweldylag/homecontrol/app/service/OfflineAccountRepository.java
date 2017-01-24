package com.paweldylag.homecontrol.app.service;

import com.paweldylag.homecontrol.app.exception.LoginException;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public class OfflineAccountRepository implements AccountRepository {

  private static OfflineAccountRepository INSTANCE;
  private final String login = "admin";
  private final String password = "admin";


  public static OfflineAccountRepository getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new OfflineAccountRepository();
    }
    return INSTANCE;
  }

  @Override
  public void login(String login, String password, AccountRepository.LoginCallback callback) {
    if (login == null || login.isEmpty()) {
      callback.onError(new LoginException(LoginException.ERROR_EMPTY_LOGIN, ""));
    } else {
      if (login.equals(this.login) && password.equals(this.password)) {
        callback.onSuccess();
      } else {
        callback.onError(new LoginException(LoginException.ERROR_WRONG_PASSWORD, ""));
      }
    }
  }


}
