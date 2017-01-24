package com.paweldylag.homecontrol.presenter;

import com.paweldylag.homecontrol.app.App;
import com.paweldylag.homecontrol.app.exception.HomeControlException;
import com.paweldylag.homecontrol.app.service.RoomRepository;
import com.paweldylag.homecontrol.model.Room;
import com.paweldylag.homecontrol.view.RoomListView;

import java.util.List;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public class RoomListPresenterImpl extends BasePresenter implements RoomListPresenter {

  private RoomListView roomListView;
  private RoomRepository roomRepository;

  public RoomListPresenterImpl(RoomListView roomListView, RoomRepository roomRepository) {
    this.roomListView = roomListView;
    this.roomRepository = roomRepository;
  }

  @Override
  public void loadRooms() {
    roomRepository.getRooms(new RoomRepository.RoomCallback() {
      @Override
      public void onSuccess(List<Room> rooms) {
        roomListView.setRooms(rooms);
      }

      @Override
      public void onError(HomeControlException e) {
        roomListView.showError(e);
      }
    });
  }

  @Override
  public void onRoomSelected(Room room) {

  }

  @Override
  public void onDestroy() {

  }
}
