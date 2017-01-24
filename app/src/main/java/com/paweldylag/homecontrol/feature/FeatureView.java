package com.paweldylag.homecontrol.feature;


import android.view.View;
import android.view.ViewGroup;

import com.paweldylag.homecontrol.view.adapter.FeatureViewHolder;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public interface FeatureView {

  void bindViewHolder(FeatureViewHolder holder);

  int getViewHolderType();

  FeatureViewHolder createViewHolder(ViewGroup v);


}

