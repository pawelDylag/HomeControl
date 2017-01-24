package com.paweldylag.homecontrol.view.adapter;

import android.support.v4.app.FragmentManager;

import com.paweldylag.homecontrol.BuildConfig;
import com.paweldylag.homecontrol.model.Room;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;


/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class RoomPagerAdapterTest {

  // ===========================================================
  // TESTS
  // ===========================================================

  @Test
  public void returns_index_for_room() {
    // given
    FragmentManager fragmentManager = Mockito.mock(FragmentManager.class);
    List<Room> roomList = new LinkedList<>();
    Room dummyRoom1 = new Room(1, "1");
    Room dummyRoom2 = new Room(2, "2");
    roomList.add(dummyRoom1);
    roomList.add(dummyRoom2);

    RoomPagerAdapter adapter = new RoomPagerAdapter(fragmentManager);
    adapter.setRooms(roomList);

    // when
    int index1 = adapter.getRoomIndex(dummyRoom1);
    int index2 = adapter.getRoomIndex(dummyRoom2);

    // then
    assertThat(index1).isEqualTo(0);
    assertThat(index2).isEqualTo(1);
  }

  @Test
  public void returns_zero_for_unknown_room() {
    // given
    FragmentManager fragmentManager = Mockito.mock(FragmentManager.class);
    List<Room> roomList = new LinkedList<>();
    Room dummyRoom1 = new Room(1, "1");
    Room unknownRoom = new Room(2, "2");
    roomList.add(dummyRoom1);

    RoomPagerAdapter adapter = new RoomPagerAdapter(fragmentManager);
    adapter.setRooms(roomList);

    // when
    int index = adapter.getRoomIndex(unknownRoom);

    // then
    assertThat(index).isEqualTo(0);
  }






  // ===========================================================
  // METHODS AND SUPPORT CLASSES
  // ===========================================================

}