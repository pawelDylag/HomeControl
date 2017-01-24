package com.paweldylag.homecontrol.feature;

import android.view.View;
import android.view.ViewGroup;

import com.paweldylag.homecontrol.model.Feature;
import com.paweldylag.homecontrol.view.adapter.FeatureViewHolder;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public class FeatureBundle {

  public Feature feature;
  public FeatureView view;

  public FeatureBundle(Feature feature, FeatureView view) {
    this.feature = feature;
    this.view = view;
  }

  public int getViewHolderType() {
    return view.getViewHolderType();
  }

  public void bindViewHolder(FeatureViewHolder holder) {
    view.bindViewHolder(holder);
  }

  public FeatureViewHolder createViewHolder(ViewGroup v) {
    return view.createViewHolder(v);
  }

}
