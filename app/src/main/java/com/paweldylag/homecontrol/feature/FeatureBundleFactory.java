package com.paweldylag.homecontrol.feature;

import com.paweldylag.homecontrol.feature.light.LightFeatureView;
import com.paweldylag.homecontrol.feature.music.MusicFeatureView;
import com.paweldylag.homecontrol.feature.temperature.TemperatureFeatureView;
import com.paweldylag.homecontrol.model.Feature;
import com.paweldylag.homecontrol.model.Room;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public class FeatureBundleFactory {

  public FeatureBundleFactory() {
  }

  public FeatureBundle getFeatureBundle(Feature feature, Room room) {
    switch(feature.type){
      case LIGHT:
        return new FeatureBundle(feature, new LightFeatureView(room));
      case TEMPERATURE:
        return new FeatureBundle(feature, new TemperatureFeatureView(room));
      case MUSIC:
        return new FeatureBundle(feature, new MusicFeatureView(room));
      default:
        return null;
    }

  }

}
