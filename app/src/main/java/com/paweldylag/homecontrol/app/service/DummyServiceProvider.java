package com.paweldylag.homecontrol.app.service;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public class DummyServiceProvider implements ServiceProvider {

  @Override
  public RoomRepository getRoomRepository() {
    return null;
  }

  @Override
  public AccountRepository getAccountRepository() {
    return null;
  }
}
