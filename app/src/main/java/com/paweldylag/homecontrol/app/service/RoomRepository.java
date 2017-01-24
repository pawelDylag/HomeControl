package com.paweldylag.homecontrol.app.service;

import com.paweldylag.homecontrol.app.exception.HomeControlException;
import com.paweldylag.homecontrol.model.Feature;
import com.paweldylag.homecontrol.model.Room;

import java.util.List;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public interface RoomRepository {

  interface RoomCallback {
    void onSuccess(List<Room> rooms);
    void onError(HomeControlException e);
  }

  interface FeatureCallback {
    void onSuccess(List<Feature> rooms);
    void onError(HomeControlException e);
  }

  interface LoadCallback {
    void onSuccess();
    void onError(HomeControlException e);
  }

  /**
   * Returns all rooms in repository.
   * @param callback
   */
  void getRooms(RoomCallback callback);

  /**
   * Returns all available features in given room
   * @param room
   */
  void getFeaturesForRoom(Room room, FeatureCallback callback);

  /**
   * Used for async loading of data from server. Does not return list of rooms.
   * See {@link RoomRepository#getRooms(RoomCallback)}
   * @param callback
   */
  void loadData(LoadCallback callback);


}
