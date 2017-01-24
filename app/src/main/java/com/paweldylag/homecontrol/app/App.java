package com.paweldylag.homecontrol.app;

import android.app.Application;
import android.content.Context;

import com.paweldylag.homecontrol.app.service.DefaultServiceProvider;
import com.paweldylag.homecontrol.app.service.ServiceProvider;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public class App extends Application {

  private static ServiceProvider serviceProvider = new DefaultServiceProvider();

  public static ServiceProvider getServiceProvider() {
    return serviceProvider;
  }



}
