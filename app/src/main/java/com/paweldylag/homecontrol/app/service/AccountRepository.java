package com.paweldylag.homecontrol.app.service;

import com.paweldylag.homecontrol.app.exception.LoginException;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public interface AccountRepository {

  interface LoginCallback {

    void onSuccess();
    void onError(LoginException e);

  }

  void login(String login, String password, LoginCallback callback);

}
