package com.paweldylag.homecontrol.view;

import com.paweldylag.homecontrol.app.exception.HomeControlException;
import com.paweldylag.homecontrol.feature.FeatureBundle;
import com.paweldylag.homecontrol.model.Feature;

import java.util.List;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public interface RoomView {

  void showFeatures(List<FeatureBundle> features);

  void showError(HomeControlException e);
}
