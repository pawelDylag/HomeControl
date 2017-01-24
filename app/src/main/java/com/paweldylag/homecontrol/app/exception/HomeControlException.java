package com.paweldylag.homecontrol.app.exception;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public class HomeControlException extends Exception{

  private int errorCode;
  private String msg;

  public HomeControlException(int errorCode, String msg) {
    this.errorCode = errorCode;
    this.msg = msg;
  }

  public int getCode() {
    return this.errorCode;
  }



}
