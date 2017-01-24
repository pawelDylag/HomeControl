package com.paweldylag.homecontrol.app.exception;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public class LoginException extends HomeControlException {

  public static final int ERROR_EMPTY_LOGIN = 0;
  public static final int ERROR_EMPTY_PASSWORD = 1;
  public static final int ERROR_WRONG_PASSWORD = 2;

  public LoginException(int errorCode, String msg) {
    super(errorCode, msg);
  }
}
