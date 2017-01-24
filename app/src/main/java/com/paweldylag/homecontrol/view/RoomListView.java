package com.paweldylag.homecontrol.view;

import com.paweldylag.homecontrol.app.exception.HomeControlException;
import com.paweldylag.homecontrol.model.Room;

import java.util.List;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public interface RoomListView {

  void setRooms(List<Room> rooms);

  void focusRoom(Room room);

  void showLoading(boolean show);

  void showError(HomeControlException e);
}
