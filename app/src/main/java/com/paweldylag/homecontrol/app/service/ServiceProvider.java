package com.paweldylag.homecontrol.app.service;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public interface ServiceProvider {

  RoomRepository getRoomRepository();

  AccountRepository getAccountRepository();

}
