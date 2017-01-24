package com.paweldylag.homecontrol.presenter;

import com.paweldylag.homecontrol.app.exception.HomeControlException;
import com.paweldylag.homecontrol.app.exception.LoginException;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public interface LoginPresenter {

  void attemptLogin(String login, String password);
}
