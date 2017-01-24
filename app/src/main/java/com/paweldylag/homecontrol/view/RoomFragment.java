package com.paweldylag.homecontrol.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paweldylag.homecontrol.R;
import com.paweldylag.homecontrol.app.exception.HomeControlException;
import com.paweldylag.homecontrol.feature.FeatureBundle;
import com.paweldylag.homecontrol.model.Feature;
import com.paweldylag.homecontrol.model.Room;
import com.paweldylag.homecontrol.presenter.RoomPresenter;
import com.paweldylag.homecontrol.presenter.RoomPresenterImpl;
import com.paweldylag.homecontrol.view.adapter.FeaturesRecyclerAdapter;

import java.util.List;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public class RoomFragment extends Fragment implements RoomView {

  private static final String ARG_ROOM = "room";

  private RoomPresenter mRoomPresenter;
  private RecyclerView mRecyclerView;
  private FeaturesRecyclerAdapter mAdapter;
  private RecyclerView.LayoutManager mLayoutManager;

  public static Fragment build(Room room) {
    Fragment fragment = new RoomFragment();
    Bundle args = new Bundle();
    args.putParcelable(ARG_ROOM, room);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Room room = getArguments().getParcelable(ARG_ROOM);
    mRoomPresenter = new RoomPresenterImpl(room, this);
    mAdapter = new FeaturesRecyclerAdapter();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_room, container, false);
    mRecyclerView = (RecyclerView) view.findViewById(R.id.features_recycler);
    mRecyclerView.setHasFixedSize(true);
    mLayoutManager = new LinearLayoutManager(getContext());
    mRecyclerView.setLayoutManager(mLayoutManager);
    mRecyclerView.setAdapter(mAdapter);
    return view;
  }

  @Override
  public void onStart() {
    super.onStart();
    mRoomPresenter.loadRoomData();
  }

  @Override
  public void showFeatures(List<FeatureBundle> features) {
    mAdapter.setFeatureBundles(features);
  }

  @Override
  public void showError(HomeControlException e) {

  }
}
