package com.paweldylag.homecontrol.app.service;

import com.paweldylag.homecontrol.app.exception.HomeControlException;
import com.paweldylag.homecontrol.model.Feature;
import com.paweldylag.homecontrol.model.FeatureType;
import com.paweldylag.homecontrol.model.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public class OfflineRoomRepository implements RoomRepository {

  private static OfflineRoomRepository INSTANCE;
  private List<Room> rooms;
  private HashMap<Room, List<Feature>> features;


  public static OfflineRoomRepository getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new OfflineRoomRepository();
    }
    return INSTANCE;
  }

  protected OfflineRoomRepository() {
    rooms = new ArrayList<>();
    rooms.add(new Room(0, "Bathroom"));
    rooms.add(new Room(1, "Kitchen"));
    rooms.add(new Room(2, "Living room"));
    List<Feature> kitchenFeatures = new LinkedList<>();
    kitchenFeatures.add(new Feature(0, "Light", FeatureType.LIGHT));
    List<Feature> bathroomFeatures = new LinkedList<>();
    bathroomFeatures.add(new Feature(2, "Light", FeatureType.LIGHT));
    bathroomFeatures.add(new Feature(3, "Music", FeatureType.MUSIC));
    List<Feature> livingRoomFeatures = new LinkedList<>();
    livingRoomFeatures.add(new Feature(5, "Light", FeatureType.LIGHT));
    livingRoomFeatures.add(new Feature(6, "Temperature", FeatureType.TEMPERATURE));
    features = new HashMap<>();
    features.put(rooms.get(0), bathroomFeatures);
    features.put(rooms.get(1), kitchenFeatures);
    features.put(rooms.get(2), livingRoomFeatures);
  }

  @Override
  public void getRooms(RoomCallback callback) {
    callback.onSuccess(new ArrayList<>(rooms));
  }

  @Override
  public void getFeaturesForRoom(Room room, FeatureCallback callback) {
    if (rooms.contains(room)){
      callback.onSuccess(features.get(room));
    } else{
      callback.onError(new HomeControlException(0, "No features for given room."));
    }
  }

  @Override
  public void loadData(LoadCallback callback) {
    callback.onSuccess();
  }
}
