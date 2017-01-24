package com.paweldylag.homecontrol.presenter;

import android.os.Build;

import com.paweldylag.homecontrol.BuildConfig;
import com.paweldylag.homecontrol.app.service.RoomRepository;
import com.paweldylag.homecontrol.model.Feature;
import com.paweldylag.homecontrol.model.Room;
import com.paweldylag.homecontrol.view.RoomListView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class RoomListPresenterImplTest {

  // ===========================================================
  // TESTS
  // ===========================================================

  @Test
  public void loads_rooms_properly() {
    // given
    RoomListView view = mock(RoomListView.class);
    RoomListPresenter presenter = new RoomListPresenterImpl(view, new MockRoomRepository());

    // when
    presenter.loadRooms();

    // then
    verify(view).setRooms(ArgumentMatchers.<Room>anyList());
  }


  // ===========================================================
  // METHODS AND SUPPORT CLASSES
  // ===========================================================

  public class MockRoomRepository implements RoomRepository {


    @Override
    public void getRooms(RoomCallback callback) {
      callback.onSuccess(new LinkedList<Room>());
    }

    @Override
    public void getFeaturesForRoom(Room room, FeatureCallback callback) {
      callback.onSuccess(new LinkedList<Feature>());
    }

    @Override
    public void loadData(LoadCallback callback) {
      callback.onSuccess();
    }
  }

}