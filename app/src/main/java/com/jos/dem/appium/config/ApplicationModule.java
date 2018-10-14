package com.jos.dem.appium.config;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class ApplicationModule {
  private final Application application;

  public ApplicationModule(Application application) {
    this.application = application;
  }

  @Provides
  @Singleton
  public Application providesApplication() {
    return application;
  }

}
