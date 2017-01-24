package com.paweldylag.homecontrol.feature.music;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.paweldylag.homecontrol.R;
import com.paweldylag.homecontrol.feature.FeatureView;
import com.paweldylag.homecontrol.feature.light.LightFeatureView;
import com.paweldylag.homecontrol.model.Room;
import com.paweldylag.homecontrol.view.adapter.FeatureViewHolder;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public class MusicFeatureView implements FeatureView {

  public MusicFeatureView(Room room) {

  }

  @Override
  public void bindViewHolder(FeatureViewHolder holder) {
    MusicViewHolder h = (MusicViewHolder) holder;
  }

  @Override
  public int getViewHolderType() {
    return 2;
  }

  @Override
  public FeatureViewHolder createViewHolder(ViewGroup v) {
    View view = LayoutInflater.from(v.getContext()).inflate(R.layout.music_feature_view, v, false);
    return new MusicFeatureView.MusicViewHolder(view);
  }

  private static class MusicViewHolder extends FeatureViewHolder {

    public Spinner spinner;
    public Switch enabled;
    public TextView currentTrack;

    public MusicViewHolder(View itemView) {
      super(itemView);
      spinner = (Spinner) itemView.findViewById(R.id.music_spinner);
      enabled = (Switch) itemView.findViewById(R.id.music_switch);
      currentTrack = (TextView) itemView.findViewById(R.id.textView_current_track);
    }
  }

}
