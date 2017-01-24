package com.paweldylag.homecontrol.app.service;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public class DefaultServiceProvider implements ServiceProvider {

  @Override
  public RoomRepository getRoomRepository() {
    return OfflineRoomRepository.getInstance();
  }

  @Override
  public AccountRepository getAccountRepository() {
    return OfflineAccountRepository.getInstance();
  }
}
