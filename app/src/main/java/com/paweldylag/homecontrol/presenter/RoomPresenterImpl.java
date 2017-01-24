package com.paweldylag.homecontrol.presenter;

import android.util.Log;

import com.paweldylag.homecontrol.app.App;
import com.paweldylag.homecontrol.app.exception.HomeControlException;
import com.paweldylag.homecontrol.app.service.RoomRepository;
import com.paweldylag.homecontrol.feature.FeatureBundle;
import com.paweldylag.homecontrol.feature.FeatureBundleFactory;
import com.paweldylag.homecontrol.model.Feature;
import com.paweldylag.homecontrol.model.Room;
import com.paweldylag.homecontrol.view.RoomView;

import java.util.LinkedList;
import java.util.List;


/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public class RoomPresenterImpl extends BasePresenter implements RoomPresenter {

  private Room room;
  private final RoomView roomView;

  public RoomPresenterImpl(Room room, RoomView roomView) {
    this.room = room;
    this.roomView = roomView;
    Log.d("RoomPresenterImpl", "Init room presenter for: " + room.name);
  }

  @Override
  public void loadRoomData() {
    App.getServiceProvider().getRoomRepository().getFeaturesForRoom(room, new RoomRepository.FeatureCallback() {
      @Override
      public void onSuccess(List<Feature> features) {
        List<FeatureBundle> featureBundles = new LinkedList<>();
        FeatureBundleFactory factory = new FeatureBundleFactory();
        for (Feature f: features) {
          featureBundles.add(factory.getFeatureBundle(f, room));
        }
        roomView.showFeatures(featureBundles);
      }

      @Override
      public void onError(HomeControlException e) {
        roomView.showError(e);
      }
    });
  }

  @Override
  public void onDestroy() {

  }
}
