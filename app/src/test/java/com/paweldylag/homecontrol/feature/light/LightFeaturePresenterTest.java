package com.paweldylag.homecontrol.feature.light;

import android.os.Build;

import com.paweldylag.homecontrol.BuildConfig;
import com.paweldylag.homecontrol.model.Room;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Java6Assertions.assertThat;


/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class LightFeaturePresenterTest {

  // ===========================================================
  // TESTS
  // ===========================================================

  @Test
  public void changes_brightness_properly() {
    // given
    LightFeaturePresenter presenter = new LightFeaturePresenter(new Room(0, "a"));
    int level = 10;

    // when
    presenter.onBrightnessChanged(level);

    // then
    assertThat(presenter.currentBrightness()).isEqualTo(level);
  }


  @Test
  public void changes_light_temperature_properly() {
    // given
    LightFeaturePresenter presenter = new LightFeaturePresenter(new Room(0, "a"));
    int level = 10;

    // when
    presenter.onTemperatureChanged(level);

    // then
    assertThat(presenter.currentTemperature()).isEqualTo(level);
  }


  // ===========================================================
  // METHODS AND SUPPORT CLASSES
  // ===========================================================

}