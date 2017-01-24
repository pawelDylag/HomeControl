package com.paweldylag.homecontrol.feature.light;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.paweldylag.homecontrol.R;
import com.paweldylag.homecontrol.model.Room;
import com.paweldylag.homecontrol.feature.FeatureView;
import com.paweldylag.homecontrol.view.adapter.FeatureViewHolder;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public class LightFeatureView implements FeatureView {

  LightFeaturePresenter lightFeaturePresenter;

  public LightFeatureView(Room room) {
    lightFeaturePresenter = new LightFeaturePresenter(room);
  }

  @Override
  public void bindViewHolder(FeatureViewHolder holder) {
    LightViewHolder h = (LightViewHolder) holder;
    h.seekBarBrightness.setProgress(lightFeaturePresenter.currentBrightness());
    h.seekBarTemperature.setProgress(lightFeaturePresenter.currentTemperature());
    h.seekBarBrightness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser) {
          lightFeaturePresenter.onBrightnessChanged(progress);
        }
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

      }
    });
    h.seekBarTemperature.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser) {
          lightFeaturePresenter.onTemperatureChanged(progress);
        }
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

      }
    });
  }

  @Override
  public int getViewHolderType() {
    return 0;
  }

  @Override
  public FeatureViewHolder createViewHolder(ViewGroup v) {
    View view = LayoutInflater.from(v.getContext()).inflate(R.layout.light_feature_layout, v, false);
    return new LightViewHolder(view);
  }

  private static class LightViewHolder extends FeatureViewHolder {

    public SeekBar seekBarBrightness, seekBarTemperature;

    public LightViewHolder(View itemView) {
      super(itemView);
      seekBarBrightness = (SeekBar) itemView.findViewById(R.id.seekBar_brightness);
      seekBarTemperature = (SeekBar) itemView.findViewById(R.id.seekBar_light_temperature);
    }
  }


}
