package com.paweldylag.homecontrol.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.paweldylag.homecontrol.feature.FeatureBundle;

import java.util.List;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public class FeaturesRecyclerAdapter extends RecyclerView.Adapter<FeatureViewHolder> {

  private List<FeatureBundle> mFeatureBundles;

  @Override
  public FeatureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    for (FeatureBundle f : mFeatureBundles) {
      if(f.getViewHolderType() == viewType) {
        return f.createViewHolder(parent);
      }
    }
    return new FeatureViewHolder(parent);
  }

  @Override
  public void onBindViewHolder(FeatureViewHolder holder, int position) {
    if (mFeatureBundles != null) {
      mFeatureBundles.get(position).bindViewHolder(holder);
    }
  }

  @Override
  public int getItemCount() {
    if (mFeatureBundles != null) {
      return mFeatureBundles.size();
    } else return 0;
  }

  @Override
  public int getItemViewType(int position) {
    if (mFeatureBundles != null) {
      return mFeatureBundles.get(position).getViewHolderType();
    } else return 0;
  }

  public void setFeatureBundles(List<FeatureBundle> featureBundles) {
    this.mFeatureBundles = featureBundles;
    this.notifyDataSetChanged();
  }


}
