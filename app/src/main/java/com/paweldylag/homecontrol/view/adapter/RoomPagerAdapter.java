package com.paweldylag.homecontrol.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.paweldylag.homecontrol.model.Room;
import com.paweldylag.homecontrol.view.RoomFragment;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public class RoomPagerAdapter extends FragmentPagerAdapter {

  private static final String TAG = RoomPagerAdapter.class.getSimpleName();

  private List<Room> mRooms;

  public RoomPagerAdapter(FragmentManager fm) {
    super(fm);
    mRooms = new LinkedList<>();
  }

  @Override
  public Fragment getItem(int position) {
    return RoomFragment.build(mRooms.get(position));
  }

  @Override
  public int getCount() {
    return mRooms.size();
  }

  @Override
  public CharSequence getPageTitle(int position) {
    return mRooms.get(position).name;
  }

  public int getRoomIndex(Room room) {
    int index = mRooms.indexOf(room);
    if (index >= 0) {
      return index;
    } else {
      Log.d(TAG, "Unable to find room with name " + room.name + " and id " + room.id);
      return 0;
    }
  }

  public void setRooms(List<Room> rooms) {
    this.mRooms = rooms;
    notifyDataSetChanged();
  }
}
