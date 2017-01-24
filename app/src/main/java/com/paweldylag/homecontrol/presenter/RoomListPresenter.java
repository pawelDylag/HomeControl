package com.paweldylag.homecontrol.presenter;

import com.paweldylag.homecontrol.model.Room;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public interface RoomListPresenter {

  void loadRooms();

  void onRoomSelected(Room room);

}
