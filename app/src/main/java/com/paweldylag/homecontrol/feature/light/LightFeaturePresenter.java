package com.paweldylag.homecontrol.feature.light;

import android.util.Log;

import com.paweldylag.homecontrol.model.Room;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public class LightFeaturePresenter {

  public static final String TAG = LightFeaturePresenter.class.getSimpleName();
  private Room room;
  private int currTemperature, currBrightness;

  public LightFeaturePresenter(Room room) {
    this.room = room;
  }

  public void onBrightnessChanged(int progress) {
    currBrightness = progress;
    Log.d(TAG, "Light brightness in " + room.name + ": " + progress);
  }

  public void onTemperatureChanged(int progress) {
    currTemperature = progress;
    Log.d(TAG, "Light temperature in " + room.name + ": " + progress);
  }

  public int currentBrightness() {
    return this.currBrightness;
  }

  public int currentTemperature() {
    return this.currTemperature;
  }
}
