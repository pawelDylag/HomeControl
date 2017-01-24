package com.paweldylag.homecontrol.feature.temperature;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.paweldylag.homecontrol.R;
import com.paweldylag.homecontrol.feature.FeatureView;
import com.paweldylag.homecontrol.model.Room;
import com.paweldylag.homecontrol.view.adapter.FeatureViewHolder;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public class TemperatureFeatureView implements FeatureView {

  TemperatureFeaturePresenter presenter;

  public TemperatureFeatureView(Room room) {
  }

  @Override
  public void bindViewHolder(FeatureViewHolder holder) {
    TemperatureViewHolder h = (TemperatureViewHolder) holder;
  }

  @Override
  public int getViewHolderType() {
    return 1;
  }

  @Override
  public FeatureViewHolder createViewHolder(ViewGroup v) {
    View view = LayoutInflater.from(v.getContext()).inflate(R.layout.temperature_feature_layout, v, false);
    return new TemperatureViewHolder(view);
  }


  private static class TemperatureViewHolder extends FeatureViewHolder {

    public SeekBar seekBarTemperature;
    public TextView textViewTemperature;

    public TemperatureViewHolder(View itemView) {
      super(itemView);
      seekBarTemperature = (SeekBar) itemView.findViewById(R.id.seekBar_light_temperature);
      textViewTemperature = (TextView) itemView.findViewById(R.id.textView_temperatures);
    }
  }

}
