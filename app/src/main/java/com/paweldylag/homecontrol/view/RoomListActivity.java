package com.paweldylag.homecontrol.view;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.paweldylag.homecontrol.R;
import com.paweldylag.homecontrol.app.App;
import com.paweldylag.homecontrol.app.exception.HomeControlException;
import com.paweldylag.homecontrol.model.Room;
import com.paweldylag.homecontrol.presenter.RoomListPresenter;
import com.paweldylag.homecontrol.presenter.RoomListPresenterImpl;
import com.paweldylag.homecontrol.view.adapter.RoomPagerAdapter;

import java.util.List;

public class RoomListActivity extends AppCompatActivity implements RoomListView {

  private static final String TAG = RoomListActivity.class.getSimpleName();

  private RoomListPresenter mRoomListPresenter;
  private ViewPager mRoomsViewPager;
  private RoomPagerAdapter mRoomPagerAdapter;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_room_list);
    mRoomListPresenter = new RoomListPresenterImpl(this, App.getServiceProvider().getRoomRepository());
    mRoomPagerAdapter = new RoomPagerAdapter(getSupportFragmentManager());
    mRoomsViewPager = (ViewPager) findViewById(R.id.rooms_pager);
    mRoomsViewPager.setAdapter(mRoomPagerAdapter);
  }

  @Override
  protected void onStart() {
    super.onStart();
    mRoomListPresenter.loadRooms();
  }

  @Override
  public void focusRoom(Room room) {
    if (mRoomsViewPager != null) {
      int roomIndex = mRoomPagerAdapter.getRoomIndex(room);
      mRoomsViewPager.setCurrentItem(roomIndex);
    }
  }

  @Override
  public void showLoading(boolean show) {

  }

  @Override
  public void setRooms(List<Room> rooms) {
    mRoomPagerAdapter.setRooms(rooms);
  }

  @Override
  public void showError(HomeControlException e) {

  }

}

